package com.app.pgbooking.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.app.pgbooking.BaseActivity;
import com.app.pgbooking.Dependencies;
import com.app.pgbooking.R;
import com.app.pgbooking.navigation.AndroidLoginNavigator;
import com.app.pgbooking.navigation.AndroidNavigator;
import com.app.pgbooking.ui.login.presenter.LoginPresenter;
import com.app.pgbooking.ui.login.view.LoginDisplayer;


/**
 * Created by marco on 27/07/16.
 */

public class LoginActivity extends BaseActivity {

    private LoginPresenter presenter;
    private AndroidLoginNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginDisplayer loginDisplayer = (LoginDisplayer) findViewById(R.id.loginView);
        LoginGoogleApiClient loginGoogleApiClient = new LoginGoogleApiClient(this);
        loginGoogleApiClient.setupGoogleApiClient();
        navigator = new AndroidLoginNavigator(this, loginGoogleApiClient, new AndroidNavigator(this));
        presenter = new LoginPresenter(
                Dependencies.INSTANCE.getLoginService(),
                loginDisplayer,
                navigator);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!navigator.onActivityResult(requestCode, resultCode, data)) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.stopPresenting();
    }

}

