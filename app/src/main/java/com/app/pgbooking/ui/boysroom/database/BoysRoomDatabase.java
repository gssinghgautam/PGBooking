package com.app.pgbooking.ui.boysroom.database;

import com.app.pgbooking.networking.RestApi;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gautam on 20/04/18.
 */

public class BoysRoomDatabase implements RoomDatabase {

    private final RestApi restApi;

    public BoysRoomDatabase(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<RoomDataResponse> observeRoomData(int page) {
        return restApi.fetchBoysRooms(page)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
