package com.app.pgbooking.ui.pgrooms.database;

import com.app.pgbooking.Constants;
import com.app.pgbooking.rx.FirebaseObservableListeners;
import com.app.pgbooking.ui.pgrooms.model.PgData;
import com.app.pgbooking.ui.pgrooms.model.PgDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by gautam on 27/03/18.
 */

public class FirebasePgDatabase implements PgDatabase {

    private static final int DEFAULT_LIMIT = 1000;
    private static final int PULL_LIMIT = 30;

    private final DatabaseReference pgData;
    private final FirebaseObservableListeners firebaseObservableListeners;

    public FirebasePgDatabase(FirebaseDatabase firebaseDatabase, FirebaseObservableListeners firebaseObservableListeners) {
        pgData = firebaseDatabase.getReference(Constants.FIREBASE_PGS);
        this.firebaseObservableListeners = firebaseObservableListeners;
    }

    @Override
    public Observable<PgDataSet> observePgDataSet() {
        return firebaseObservableListeners.listenToValueEvents(pgData.limitToLast(DEFAULT_LIMIT), toPgs());
    }

    private Func1<DataSnapshot, PgDataSet> toPgs() {
        return new Func1<DataSnapshot, PgDataSet>() {
            @Override
            public PgDataSet call(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                List<PgData> pgDataList = new ArrayList<>();
                for (DataSnapshot child : children) {
                    PgData pgData = child.getValue(PgData.class);
                    pgData.setPgId(child.getKey());
                    pgDataList.add(pgData);
                }
                return new PgDataSet(pgDataList);
            }
        };
    }
}
