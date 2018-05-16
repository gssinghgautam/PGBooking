package com.app.pgbooking.ui.boysroom.presenter;

import com.app.pgbooking.navigation.AndroidPgNavigator;
import com.app.pgbooking.ui.boysroom.service.BoysRoomService;
import com.app.pgbooking.ui.boysroom.view.BoysRoomDisplayer;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gautam on 20/04/18.
 */

public class BoysRoomPresenter {

    private final BoysRoomDisplayer mBoysRoomDisplayer;
    private final BoysRoomService mBoysRoomService;
    private AndroidPgNavigator navigator;

    private Subscription subscription;

    public BoysRoomPresenter(BoysRoomDisplayer mBoysRoomDisplayer, BoysRoomService mBoysRoomService, AndroidPgNavigator navigator) {
        this.mBoysRoomDisplayer = mBoysRoomDisplayer;
        this.mBoysRoomService = mBoysRoomService;
        this.navigator = navigator;
    }

    public void startPresenting() {
        mBoysRoomDisplayer.attach(interactionListener);
        subscription = mBoysRoomService.fetchRoomData(1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(roomDataResponseSubscriber);
    }


    private Subscriber<RoomDataResponse> roomDataResponseSubscriber = new Subscriber<RoomDataResponse>() {

        @Override
        public void onCompleted() {
            mBoysRoomDisplayer.hideProgress();
        }

        @Override
        public void onError(Throwable e) {
            mBoysRoomDisplayer.hideProgress();
        }

        @Override
        public void onNext(RoomDataResponse roomDataResponse) {
            mBoysRoomDisplayer.hideProgress();
            if (roomDataResponse.getStatus()) {
                mBoysRoomDisplayer.display(roomDataResponse);
            }
        }
    };


    public void stopPresenting() {
        mBoysRoomDisplayer.detach(interactionListener);
        subscription.unsubscribe();
    }

    private final BoysRoomDisplayer.PgInteractionListener interactionListener = new BoysRoomDisplayer.PgInteractionListener() {
        @Override
        public void onPgSelected(RoomData roomData) {
            navigator.toSelectedPg(roomData);
        }
    };
}
