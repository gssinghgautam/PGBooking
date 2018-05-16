package com.app.pgbooking.ui.pgdetails.database;

import com.app.pgbooking.ui.pgdetails.model.RoomDetailsDataResponse;

import rx.Observable;

/**
 * Created by gautam on 21/04/18.
 */

public interface RoomDetailsDatabase {

    Observable<RoomDetailsDataResponse> fetchRoomDetails(String id);
}
