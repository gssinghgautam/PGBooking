package com.app.pgbooking.ui.girlsroom.database;

import com.app.pgbooking.networking.RestApi;
import com.app.pgbooking.ui.boysroom.database.RoomDatabase;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gautam on 21/04/18.
 */

public class GirlsRoomDatabase implements RoomDatabase {
    private final RestApi restApi;

    public GirlsRoomDatabase(RestApi restApi) {
        this.restApi = restApi;
    }

    @Override
    public Observable<RoomDataResponse> observeRoomData(int page) {
        return restApi.fetchGirlsRoom(page)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
