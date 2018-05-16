package com.app.pgbooking.networking;

import com.app.pgbooking.Constants;
import com.app.pgbooking.ui.pgdetails.model.RoomDetailsDataResponse;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gautam on 20/04/18.
 */

public interface RestApi {

    @GET(Constants.BOYS_PG_URL)
    Observable<RoomDataResponse> fetchBoysRooms(@Query("page") int page);

    @GET(Constants.GIRLS_PG_URL)
    Observable<RoomDataResponse> fetchGirlsRoom(@Query("page") int page);

    @GET(Constants.ROOM_DETAILS_URL)
    Observable<RoomDetailsDataResponse> fetchRoomDetails(@Query("id") String id);


}
