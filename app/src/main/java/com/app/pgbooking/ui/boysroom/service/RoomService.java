package com.app.pgbooking.ui.boysroom.service;

import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Observable;

/**
 * Created by gautam on 20/04/18.
 */

public interface RoomService {

    Observable<RoomDataResponse> fetchRoomData(int page);
}
