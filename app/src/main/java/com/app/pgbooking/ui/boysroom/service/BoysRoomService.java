package com.app.pgbooking.ui.boysroom.service;

import com.app.pgbooking.ui.boysroom.database.RoomDatabase;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;

/**
 * Created by gautam on 20/04/18.
 */

public class BoysRoomService implements RoomService {

    private final RoomDatabase mRoomDatabase;

    public BoysRoomService(RoomDatabase mRoomDatabase) {
        this.mRoomDatabase = mRoomDatabase;
    }

    @Override
    public Observable<RoomDataResponse> fetchRoomData(int page) {
        return mRoomDatabase.observeRoomData(page);
    }
}
