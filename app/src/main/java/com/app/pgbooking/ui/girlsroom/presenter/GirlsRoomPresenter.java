package com.app.pgbooking.ui.girlsroom.presenter;

import com.app.pgbooking.navigation.AndroidPgNavigator;
import com.app.pgbooking.ui.girlsroom.service.GirlsRoomService;
import com.app.pgbooking.ui.girlsroom.view.GirlsRoomDisplayer;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gautam on 21/04/18.
 */

public class GirlsRoomPresenter {
    private final GirlsRoomDisplayer mGirlsRoomDisplayer;
    private final GirlsRoomService mGirlsRoomService;
    private AndroidPgNavigator navigator;

    private Subscription subscription;

    public GirlsRoomPresenter(GirlsRoomDisplayer mGirlsRoomDisplayer, GirlsRoomService mGirlsRoomService, AndroidPgNavigator navigator) {
        this.mGirlsRoomDisplayer = mGirlsRoomDisplayer;
        this.mGirlsRoomService = mGirlsRoomService;
        this.navigator = navigator;
    }

    public void startPresenting() {
        mGirlsRoomDisplayer.attach(interactionListener);
        subscription = mGirlsRoomService.fetchRoomData(1)
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(roomDataResponseSubscriber);
    }


    private Subscriber<RoomDataResponse> roomDataResponseSubscriber = new Subscriber<RoomDataResponse>() {

        @Override
        public void onCompleted() {
            mGirlsRoomDisplayer.hideProgress();
        }

        @Override
        public void onError(Throwable e) {
            mGirlsRoomDisplayer.hideProgress();
        }

        @Override
        public void onNext(RoomDataResponse roomDataResponse) {
            mGirlsRoomDisplayer.hideProgress();
            if (roomDataResponse.getStatus()) {
                mGirlsRoomDisplayer.display(roomDataResponse);
            }
        }
    };

    public void stopPresenting() {
        mGirlsRoomDisplayer.detach(interactionListener);
        subscription.unsubscribe();
    }

    private final GirlsRoomDisplayer.PgInteractionListener interactionListener = new GirlsRoomDisplayer.PgInteractionListener() {
        @Override
        public void onPgSelected(RoomData roomData) {
            navigator.toSelectedPg(roomData);
        }
    };
}
