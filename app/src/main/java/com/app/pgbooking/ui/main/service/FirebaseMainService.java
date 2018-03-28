package com.app.pgbooking.ui.main.service;

import com.app.pgbooking.ui.user.database.UserDatabase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by gautam on 26/03/18.
 */

public class FirebaseMainService implements MainService {

    private final FirebaseAuth firebaseAuth;
    private final UserDatabase userDatabase;

    public FirebaseMainService(FirebaseAuth firebaseAuth, UserDatabase userDatabase) {
        this.firebaseAuth = firebaseAuth;
        this.userDatabase = userDatabase;
    }

    @Override
    public String getLoginProvider() throws Exception {
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if (firebaseUser != null)
            return firebaseUser.getProviders().get(0);
        else
            throw new Exception("Couldn't getMessage the provider");
    }

    @Override
    public void logout() {
        firebaseAuth.signOut();
    }

    /*private MainDatabase mainDatabase;

    public FirebaseMainService(MainDatabase mainDatabase) {
        this.mainDatabase = mainDatabase;
    }

    @Override
    public Observable<DatabaseResult<PgDataSet>> getPgDataSet() {
        return mainDatabase.observePgDataSet()
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
    }*/
}
