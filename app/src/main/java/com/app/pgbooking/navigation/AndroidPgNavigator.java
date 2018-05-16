package com.app.pgbooking.navigation;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;

import com.app.pgbooking.Constants;
import com.app.pgbooking.ui.pgdetails.RoomDetailsActivity;
import com.app.pgbooking.ui.pgdetails.model.RoomDetailsData;
import com.app.pgbooking.ui.pgrooms.model.RoomData;

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

    public void toSelectedPg(RoomData roomData) {
        Intent intent = new Intent(activity, RoomDetailsActivity.class);
        intent.putExtra(Constants.ROOM_DATA, roomData);
        if ("custom".equalsIgnoreCase(roomData.getType())) {
            intent.putExtra(Constants.TYPE, roomData.getType());
        }
        activity.startActivity(intent);
    }

    public void toGoogleMap(RoomDetailsData roomDetailsData) {
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(String.format("http://maps.google.com/maps?daddr=%s", roomDetailsData.getLatitude() + "," + roomDetailsData.getLongitude())));
        activity.startActivity(intent);
    }

    public void toShare() {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Let me recommend you this application  " + "https://play.google.com/store/apps/details?id=" + activity.getPackageName());
        try {
            activity.startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
        }
    }
}
