package com.app.pgbooking.ui.pgdetails.service;

import com.app.pgbooking.ui.pgdetails.model.RoomDetailsDataResponse;
import com.app.pgbooking.ui.pgdetails.database.RoomDetailsDatabase;

import rx.Observable;

/**
 * Created by gautam on 21/04/18.
 */

public class PgRoomDataDetailsService implements RoomDetailsService {

    private final RoomDetailsDatabase mRoomDatabase;

    public PgRoomDataDetailsService(RoomDetailsDatabase mRoomDatabase) {
        this.mRoomDatabase = mRoomDatabase;
    }

    @Override
    public Observable<RoomDetailsDataResponse> getRoomDataDetails(String id) {
        return mRoomDatabase.fetchRoomDetails(id);
    }
}
