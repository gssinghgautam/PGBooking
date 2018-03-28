package com.app.pgbooking.ui.user.database;

import com.app.pgbooking.ui.user.data_model.User;
import com.app.pgbooking.ui.user.data_model.Users;

import rx.Observable;

/**
 * Created by marco on 27/07/16.
 */

public interface UserDatabase {

    Observable<Users> observeUsers();

    Observable<User> readUserFrom(String userId);

    Observable<Users> singleObserveUsers();

    Observable<User> observeUser(String userId);

    Observable<Boolean>  initUserLastSeen();

    void setUserLastSeen(String userId);

    void setUserName(String userId, String name);

    void setUserImage(String userId, String image);

}
