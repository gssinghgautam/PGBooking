package com.app.pgbooking.ui.pgdetails.database;

import com.app.pgbooking.networking.RestApi;
import com.app.pgbooking.ui.pgdetails.model.RoomDetailsDataResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gautam on 21/04/18.
 */

public class PGRoomDataDetailsDatabase implements RoomDetailsDatabase {

    private final RestApi mRestApi;

    public PGRoomDataDetailsDatabase(RestApi mRestApi) {
        this.mRestApi = mRestApi;
    }

    @Override
    public Observable<RoomDetailsDataResponse> fetchRoomDetails(String id) {
        return mRestApi.fetchRoomDetails(id)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
