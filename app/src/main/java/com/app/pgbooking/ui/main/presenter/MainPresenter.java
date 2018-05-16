package com.app.pgbooking.ui.main.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.app.pgbooking.R;
import com.app.pgbooking.navigation.AndroidMainNavigator;
import com.app.pgbooking.ui.login.data_model.Authentication;
import com.app.pgbooking.ui.login.service.LoginService;
import com.app.pgbooking.ui.main.service.MainService;
import com.app.pgbooking.ui.main.view.MainDisplayer;
import com.app.pgbooking.ui.user.data_model.User;
import com.app.pgbooking.ui.user.service.UserService;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;

/**
 * Created by gautam on 26/03/18.
 */

public class MainPresenter {

    private AppCompatActivity activity;

    private final LoginService loginService;
    private final UserService userService;
    private final MainDisplayer mainDisplayer;
    private final MainService mainService;
    private final AndroidMainNavigator navigator;

    private Subscription loginSubscription;

    public MainPresenter(LoginService loginService,
                         UserService userService,
                         MainDisplayer mainDisplayer,
                         MainService mainService,
                         AndroidMainNavigator navigator,
                         AppCompatActivity activity) {
        this.loginService = loginService;
        this.userService = userService;
        this.mainDisplayer = mainDisplayer;
        this.mainService = mainService;
        this.navigator = navigator;
        this.activity = activity;
    }

    public void startPresenting() {
        navigator.init();
        mainDisplayer.attach(drawerActionListener,navigationActionListener);

        loginSubscription = loginService.getAuthentication()
                .first()
                .flatMap(getUser())
                .subscribe(userSubscriber());
    }

    public void stopPresenting() {
        mainDisplayer.detach(drawerActionListener,navigationActionListener);
        loginSubscription.unsubscribe();
    }

    private Func1<Authentication, Observable<User>> getUser() {
        return new Func1<Authentication, Observable<User>>() {
            @Override
            public Observable<User> call(Authentication authentication) {
                if (!authentication.isSuccess()) {
                    navigator.toLogin();
                    return Observable.empty();
                }
                return userService.getUser(authentication.getUser().getUid());
            }
        };
    }

    private Subscriber<User> userSubscriber() {
        return new Subscriber<User>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                navigator.toFirstLogin();
            }

            @Override
            public void onNext(User user) {
                mainDisplayer.setUser(user);
            }
        };
    }

    private final MainDisplayer.DrawerActionListener drawerActionListener = new MainDisplayer.DrawerActionListener() {

        @Override
        public void onHeaderSelected() {
            navigator.toProfile();
        }

        @Override
        public void onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_bookings:
                    //navigator.toConversations();
                    //mainDisplayer.setTitle(activity.getString(R.string.conversations_toolbar_title));
                    mainDisplayer.clearMenu();
                    break;
                case R.id.profile:
                    navigator.toProfile();
                    break;
                case R.id.nav_share:
                    navigator.toShare();
                    break;
                case R.id.logout:
                    try {
                        if (mainService.getLoginProvider().equals("google.com"))
                            navigator.toGoogleSignOut(AndroidMainNavigator.LOGOUT_GOOGLE);
                        mainService.logout();
                        navigator.toLogin();
                    } catch (Exception e) {

                    }
            }
            mainDisplayer.closeDrawer();
        }

    };

    private final MainDisplayer.NavigationActionListener navigationActionListener = new MainDisplayer.NavigationActionListener() {

        @Override
        public void onHamburgerPressed() {
            mainDisplayer.openDrawer();
        }

    };


    public boolean onBackPressed() {
        return mainDisplayer.onBackPressed();
    }

}
