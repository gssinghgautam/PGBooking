package com.app.pgbooking.ui.login.service;

import com.app.pgbooking.ui.login.data_model.Authentication;
import com.app.pgbooking.ui.login.database.AuthDatabase;
import com.jakewharton.rxrelay.BehaviorRelay;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Created by marco on 27/07/16.
 */

public class FirebaseLoginService implements LoginService {

    private final AuthDatabase authDatabase;
    private BehaviorRelay<Authentication> authRelay;

    public FirebaseLoginService(AuthDatabase authDatabase) {
        this.authDatabase = authDatabase;
        authRelay = BehaviorRelay.create();
    }

    @Override
    public Observable<Authentication> getAuthentication() {
        return authRelay
                .startWith(initRelay());
    }

    private Observable<Authentication> initRelay() {
        return Observable.defer(new Func0<Observable<Authentication>>() {
            @Override
            public Observable<Authentication> call() {
                if (authRelay.hasValue() && authRelay.getValue().isSuccess()) {
                    return Observable.empty();
                } else {
                    return fetchUser();
                }
            }
        });
    }

    private Observable<Authentication> fetchUser() {
        return authDatabase.readAuthentication()
                .doOnNext(authRelay)
                .ignoreElements();
    }

    @Override
    public void loginWithGoogle(String idToken) {
        authDatabase.loginWithGoogle(idToken)
                .subscribe(new Action1<Authentication>() {
                    @Override
                    public void call(Authentication authentication) {
                        if (authentication.isSuccess()) {
                        }
                        authRelay.call(authentication);
                    }
                });
    }

    @Override
    public void loginWithEmailAndPass(final String email, final String password) {
        authDatabase.loginWithEmailAndPass(email,password)
                .subscribe(new Action1<Authentication>() {
                    @Override
                    public void call(Authentication authentication) {
                        if (authentication.isSuccess()) {
                        }
                        authRelay.call(authentication);
                    }
                });
    }

    @Override
    public void sendPasswordResetEmail(String email) {
        authDatabase.sendPasswordResetEmail(email);
    }

}