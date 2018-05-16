package com.app.pgbooking.ui.pgdetails.view;

import com.app.pgbooking.ui.pgdetails.model.RoomDetailsData;

/**
 * Created by gautam on 21/04/18.
 */

public interface RoomDetailsDisplayer {

    void display(RoomDetailsData roomDetailsData);

    void showProgress();

    void hideProgress();

    void attach(RoomInteractionListener listener);

    void detach(RoomInteractionListener listener);

    interface RoomInteractionListener {

        void onRoomEnquirySelected(RoomDetailsData roomDetailsData);

        void onDirection(RoomDetailsData roomDetailsData);
    }
}
