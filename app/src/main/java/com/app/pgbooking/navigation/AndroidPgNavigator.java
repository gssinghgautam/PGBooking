package com.app.pgbooking.navigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.pgbooking.navigation.Navigator;

/**
 * Created by gautam on 27/03/18.
 */

public class AndroidPgNavigator implements Navigator {

    private final AppCompatActivity activity;
    private final Navigator navigator;

    public AndroidPgNavigator(AppCompatActivity activity, Navigator navigator) {
        this.activity = activity;
        this.navigator = navigator;
    }

    @Override
    public void toLogin() {

    }

    @Override
    public void toMainActivity() {

    }

    @Override
    public void toParent() {
        activity.onBackPressed();
    }

    public void toSelectedPg(Bundle bundle) {
        /*Intent intent = new Intent(activity, ConversationActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);*/
    }
}
