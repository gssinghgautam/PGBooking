package com.app.pgbooking.ui.pgdetails.presenter;

import com.app.pgbooking.navigation.AndroidPgNavigator;
import com.app.pgbooking.ui.pgdetails.model.RoomDetailsData;
import com.app.pgbooking.ui.pgdetails.model.RoomDetailsDataResponse;
import com.app.pgbooking.ui.pgdetails.service.RoomDetailsService;
import com.app.pgbooking.ui.pgdetails.view.RoomDetailsDisplayer;
import com.app.pgbooking.ui.pgrooms.model.RoomData;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by gautam on 21/04/18.
 */

public class RoomDetailsPresenter {

    private final RoomDetailsDisplayer mRoomDetailsDisplayer;
    private final RoomDetailsService mRoomDetailsService;
    private AndroidPgNavigator navigator;
    private Subscription subscription;
    private final RoomData roomData;

    public RoomDetailsPresenter(
            RoomDetailsDisplayer mRoomDetailsDisplayer,
            RoomDetailsService mRoomDetailsService,
            AndroidPgNavigator navigator,
            RoomData roomData
    ) {
        this.mRoomDetailsDisplayer = mRoomDetailsDisplayer;
        this.mRoomDetailsService = mRoomDetailsService;
        this.navigator = navigator;
        this.roomData = roomData;
    }


    public void startPresenting() {
        mRoomDetailsDisplayer.attach(roomInteractionListener);
        //mRoomDetailsDisplayer.showProgress();
        subscription = mRoomDetailsService.getRoomDataDetails(roomData.getId())
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(roomDetailsDataResponseSubscriber);
    }

    private Subscriber<RoomDetailsDataResponse> roomDetailsDataResponseSubscriber = new Subscriber<RoomDetailsDataResponse>() {
        @Override
        public void onCompleted() {
            mRoomDetailsDisplayer.hideProgress();
        }

        @Override
        public void onError(Throwable e) {
            mRoomDetailsDisplayer.hideProgress();
        }

        @Override
        public void onNext(RoomDetailsDataResponse roomDetailsDataResponse) {
            mRoomDetailsDisplayer.hideProgress();
            if (roomDetailsDataResponse.getStatus()) {
                RoomDetailsData dataResponse = roomDetailsDataResponse.getData().get(0);
                dataResponse.setPostTitle(roomData.getPostTitle());
                dataResponse.setPostAddress(roomData.getPostAddress());
                if ("custom".equalsIgnoreCase(roomData.getType())) {
                    dataResponse.setLatitude(roomData.getLat());
                    dataResponse.setLongitude(roomData.getLng());
                    dataResponse.setPostInfo(roomData.getPostInfo());
                    dataResponse.setPostPhotoFeatured(roomData.getPostPhotoFeatured());
                }
                mRoomDetailsDisplayer.display(dataResponse);
            }
        }
    };

    public void stopPresenting() {
        mRoomDetailsDisplayer.detach(roomInteractionListener);
        subscription.unsubscribe();
    }

    private final RoomDetailsDisplayer.RoomInteractionListener roomInteractionListener = new RoomDetailsDisplayer.RoomInteractionListener() {
        @Override
        public void onRoomEnquirySelected(RoomDetailsData roomDetailsData) {

        }

        @Override
        public void onDirection(RoomDetailsData roomDetailsData) {
            navigator.toGoogleMap(roomDetailsData);
        }
    };

}
