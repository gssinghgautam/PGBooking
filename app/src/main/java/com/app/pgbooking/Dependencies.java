package com.app.pgbooking;

import android.content.Context;

import com.app.pgbooking.networking.RestApi;
import com.app.pgbooking.networking.RetroSingleton;
import com.app.pgbooking.rx.FirebaseObservableListeners;
import com.app.pgbooking.storage.FirebaseStorageService;
import com.app.pgbooking.storage.StorageService;
import com.app.pgbooking.ui.boysroom.database.BoysRoomDatabase;
import com.app.pgbooking.ui.boysroom.service.BoysRoomService;
import com.app.pgbooking.ui.girlsroom.database.GirlsRoomDatabase;
import com.app.pgbooking.ui.girlsroom.service.GirlsRoomService;
import com.app.pgbooking.ui.login.database.FirebaseAuthDatabase;
import com.app.pgbooking.ui.login.service.FirebaseLoginService;
import com.app.pgbooking.ui.login.service.LoginService;
import com.app.pgbooking.ui.main.service.FirebaseMainService;
import com.app.pgbooking.ui.main.service.MainService;
import com.app.pgbooking.ui.pgdetails.database.PGRoomDataDetailsDatabase;
import com.app.pgbooking.ui.pgdetails.service.PgRoomDataDetailsService;
import com.app.pgbooking.ui.profile.service.FirebaseProfileService;
import com.app.pgbooking.ui.profile.service.ProfileService;
import com.app.pgbooking.ui.registration.service.FirebaseRegistrationService;
import com.app.pgbooking.ui.registration.service.RegistrationService;
import com.app.pgbooking.ui.user.database.FirebaseUserDatabase;
import com.app.pgbooking.ui.user.service.PersistedUserService;
import com.app.pgbooking.ui.user.service.UserService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

/**
 * Created by gautam on 26/03/18.
 */

public enum Dependencies {
    INSTANCE;

    private RegistrationService registrationService;
    private LoginService loginService;
    private StorageService storageService;
    private UserService userService;
    private ProfileService profileService;
    private MainService mainService;
    private BoysRoomService boysRoomService;
    private GirlsRoomService girlsRoomService;
    private PgRoomDataDetailsService roomDetailsService;

    public void init(Context context) {
        if (needsInitialisation()) {
            Context appContext = context.getApplicationContext();
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
//            if (!setPersistence) {
//                FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//                setPersistence = true;
//            }
            FirebaseObservableListeners firebaseObservableListeners = new FirebaseObservableListeners();
            FirebaseUserDatabase userDatabase = new FirebaseUserDatabase(firebaseDatabase, firebaseObservableListeners);
            FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();
            loginService = new FirebaseLoginService(new FirebaseAuthDatabase(firebaseAuth));
            registrationService = new FirebaseRegistrationService(firebaseAuth);
            userService = new PersistedUserService(userDatabase);
            profileService = new FirebaseProfileService(firebaseAuth);
            storageService = new FirebaseStorageService(firebaseStorage, firebaseObservableListeners);
            mainService = new FirebaseMainService(firebaseAuth, userDatabase);
            RestApi restApi = RetroSingleton.getInstance().getRestApi();
            boysRoomService = new BoysRoomService(new BoysRoomDatabase(restApi));
            girlsRoomService = new GirlsRoomService(new GirlsRoomDatabase(restApi));
            roomDetailsService = new PgRoomDataDetailsService(new PGRoomDataDetailsDatabase(restApi));
        }
    }

    private boolean needsInitialisation() {
        return loginService == null || registrationService == null || storageService != null
                || userService == null || profileService == null; //|| errorLogger == null;
    }

    public LoginService getLoginService() {
        return loginService;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public StorageService getStorageService() {
        return storageService;
    }

    public ProfileService getProfileService() {
        return profileService;
    }

    public UserService getUserService() {
        return userService;
    }

    public MainService getMainService() {
        return mainService;
    }

    public GirlsRoomService getGirlsRoomService() {
        return girlsRoomService;
    }

    public BoysRoomService getBoysRoomService() {
        return boysRoomService;
    }

    public PgRoomDataDetailsService getRoomDetailsService() {
        return roomDetailsService;
    }

    public void clearDependecies() {
        loginService = null;
        userService = null;
    }
}
