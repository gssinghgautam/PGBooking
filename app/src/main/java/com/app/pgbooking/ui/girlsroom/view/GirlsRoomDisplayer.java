package com.app.pgbooking.ui.girlsroom.view;

import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

/**
 * Created by gautam on 21/04/18.
 */

public interface GirlsRoomDisplayer {

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

