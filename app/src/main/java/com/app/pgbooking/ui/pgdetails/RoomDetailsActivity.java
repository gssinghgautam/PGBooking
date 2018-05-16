package com.app.pgbooking.ui.pgdetails;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.app.pgbooking.Constants;
import com.app.pgbooking.Dependencies;
import com.app.pgbooking.R;
import com.app.pgbooking.navigation.AndroidNavigator;
import com.app.pgbooking.navigation.AndroidPgNavigator;
import com.app.pgbooking.ui.pgdetails.presenter.RoomDetailsPresenter;
import com.app.pgbooking.ui.pgdetails.view.RoomDetailsDisplayer;
import com.app.pgbooking.ui.pgrooms.model.RoomData;

public class RoomDetailsActivity extends AppCompatActivity {

    private RoomDetailsPresenter mPresenter;
    private AndroidPgNavigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        String id = getIntent().getStringExtra(Constants.ROOM_ID);
        RoomData roomData = getIntent().getParcelableExtra(Constants.ROOM_DATA);
        navigator = new AndroidPgNavigator(this, new AndroidNavigator(this));
        mPresenter = new RoomDetailsPresenter(
                (RoomDetailsDisplayer) findViewById(R.id.room_details),
                Dependencies.INSTANCE.getRoomDetailsService(),
                navigator,
                roomData
        );
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.startPresenting();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.stopPresenting();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
