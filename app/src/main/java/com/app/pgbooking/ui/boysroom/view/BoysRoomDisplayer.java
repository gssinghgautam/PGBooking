package com.app.pgbooking.ui.boysroom.view;

import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

/**
 * Created by gautam on 20/04/18.
 */

public interface BoysRoomDisplayer {

    void display(RoomDataResponse roomDataResponse);

    void addToDisplay(RoomData roomData);

    void showProgress();

    void hideProgress();

    void attach(PgInteractionListener pgInteractionListener);

    void detach(PgInteractionListener pgInteractionListener);


    public interface PgInteractionListener {

        void onPgSelected(RoomData roomData);

    }
}
