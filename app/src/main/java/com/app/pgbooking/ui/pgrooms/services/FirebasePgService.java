package com.app.pgbooking.ui.pgrooms.services;

import com.app.pgbooking.database.DatabaseResult;
import com.app.pgbooking.ui.pgrooms.database.PgDatabase;
import com.app.pgbooking.ui.pgrooms.model.PgDataSet;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by gautam on 27/03/18.
 */

public class FirebasePgService implements PgService {

    private final PgDatabase pgDatabase;

    public FirebasePgService(PgDatabase pgDatabase) {
        this.pgDatabase = pgDatabase;
    }

    @Override
    public Observable<DatabaseResult<PgDataSet>> getPgDataSet() {
        return pgDatabase.observePgDataSet()
                .map(asDatabaseResult())
                .onErrorReturn(DatabaseResult.<PgDataSet>errorAsDatabaseResult());
    }

    private static Func1<PgDataSet, DatabaseResult<PgDataSet>> asDatabaseResult() {
        return new Func1<PgDataSet, DatabaseResult<PgDataSet>>() {
            @Override
            public DatabaseResult<PgDataSet> call(PgDataSet pgDataSet) {
                return new DatabaseResult<>(pgDataSet);
            }
        };
    }
}
