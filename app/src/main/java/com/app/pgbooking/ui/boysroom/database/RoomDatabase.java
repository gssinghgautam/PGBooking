package com.app.pgbooking.ui.boysroom.database;

import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;

/**
 * Created by gautam on 20/04/18.
 */

public interface RoomDatabase {

    Observable<RoomDataResponse> observeRoomData(int page);

}
