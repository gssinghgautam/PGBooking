package com.app.pgbooking.ui.girlsroom.service;

import com.app.pgbooking.ui.boysroom.database.RoomDatabase;
import com.app.pgbooking.ui.boysroom.service.RoomService;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;

/**
 * Created by gautam on 21/04/18.
 */

public class GirlsRoomService implements RoomService {

    private final RoomDatabase mRoomDatabase;

    public GirlsRoomService(RoomDatabase mRoomDatabase) {
        this.mRoomDatabase = mRoomDatabase;
    }

    @Override
    public Observable<RoomDataResponse> fetchRoomData(int page) {
        return mRoomDatabase.observeRoomData(page);
    }
}
