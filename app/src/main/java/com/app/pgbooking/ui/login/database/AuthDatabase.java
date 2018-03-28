package com.app.pgbooking.ui.login.database;



import com.app.pgbooking.ui.login.data_model.Authentication;

import rx.Observable;

/**
 * Created by marco on 27/07/16.
 */

public interface AuthDatabase {

    Observable<Authentication> readAuthentication();

    Observable<Authentication> loginWithGoogle(String idToken);

    Observable<Authentication> loginWithEmailAndPass(String email, String password);

    void sendPasswordResetEmail(String email);

}
