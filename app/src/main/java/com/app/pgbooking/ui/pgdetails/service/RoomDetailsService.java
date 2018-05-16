package com.app.pgbooking.ui.pgdetails.service;

import com.app.pgbooking.ui.pgdetails.model.RoomDetailsDataResponse;

import rx.Observable;

/**
 * Created by gautam on 21/04/18.
 */

public interface RoomDetailsService {

    Observable<RoomDetailsDataResponse> getRoomDataDetails(String id);
}
