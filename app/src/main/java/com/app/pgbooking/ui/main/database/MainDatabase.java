package com.app.pgbooking.ui.main.database;

import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;

/**
 * Created by gautam on 26/03/18.
 */

public interface MainDatabase {

    Observable<RoomDataResponse> observePgDataSet();
}
