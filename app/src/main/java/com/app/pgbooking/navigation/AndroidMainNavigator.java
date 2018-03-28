
package com.app.pgbooking.navigation;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.app.pgbooking.Dependencies;
import com.app.pgbooking.R;
import com.app.pgbooking.ui.firstlogin.UserFirstLoginActivity;
import com.app.pgbooking.ui.login.LoginActivity;
import com.app.pgbooking.ui.pgrooms.PgListFragment;
import com.app.pgbooking.ui.profile.ProfileActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;

public class AndroidMainNavigator implements MainNavigator {

    private static final String TAG = AndroidMainNavigator.class.getSimpleName();
    private static final int REQUEST_INVITE = 1;
    public static final int LOGOUT_GOOGLE = 1;

    private boolean doubleBackToExitPressedOnce = false;
    private boolean firstOpen = true;

    private final AppCompatActivity activity;
    private final GoogleApiClient googleApiClient;

    private MaterialDialog progressDialog;

    public AndroidMainNavigator(AppCompatActivity activity, @Nullable GoogleApiClient googleApiClient) {
        this.activity = activity;
        this.googleApiClient = googleApiClient;
    }


    @Override
    public void attach() {

    }

    @Override
    public void detach() {

    }

    @Override
    public void init() {
        if (firstOpen) {
            this.toPgRooms();
            firstOpen = false;
        }
    }

    private void toPgRooms() {
        PgListFragment pgListFragment = new PgListFragment();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, pgListFragment)
                .commit();
    }

    @Override
    public void toMyBookings() {
        /*ConversationListFragment conversationsFragment = new ConversationListFragment();
        activity.getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,conversationsFragment)
                .commit();*/
    }

    @Override
    public void toProfile() {
        activity.startActivity(new Intent(activity, ProfileActivity.class));
    }

    @Override
    public void toFirstLogin() {
        activity.startActivity(new Intent(activity, UserFirstLoginActivity.class));
    }

    @Override
    public void toGoogleSignOut(int method) {
        Toast.makeText(activity, R.string.main_toast_logout_message, Toast.LENGTH_LONG).show();
        if (method == LOGOUT_GOOGLE) {
            Auth.GoogleSignInApi.signOut(googleApiClient);
        }
    }

    @Override
    public void toLogin() {
        Dependencies.INSTANCE.clearDependecies();
        activity.startActivity(new Intent(activity, LoginActivity.class));
        activity.finishAffinity();
    }

    @Override
    public void showProgressDialog() {
        progressDialog = new MaterialDialog.Builder(activity)
                .content(R.string.main_dialog_text_wait)
                .progress(true, 0)
                .show();
    }

    @Override
    public void hideProgressDialog() {
        progressDialog.dismiss();
    }

    @Override
    public Boolean onBackPressed() {
        if (doubleBackToExitPressedOnce)
            activity.finishAffinity();

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(activity, R.string.main_toast_exit_message, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
        return true;
    }
}
