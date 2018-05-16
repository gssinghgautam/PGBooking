package com.app.pgbooking.ui.pgdetails.view;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.pgbooking.R;
import com.app.pgbooking.Utils;
import com.app.pgbooking.ui.booking.PGBookingActivity;
import com.app.pgbooking.ui.pgdetails.model.RoomDetailsData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gautam on 21/04/18.
 */

public class RoomDetailsView extends CoordinatorLayout implements RoomDetailsDisplayer {

    @BindView(R.id.backdrop)
    ImageView backdrop;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_city)
    TextView tvCity;

    @BindView(R.id.btn_type)
    Button btnType;

    @BindView(R.id.post_type)
    TextView postType;

    @BindView(R.id.post_available)
    TextView postAvailable;

    @BindView(R.id.post_bedroom)
    TextView postBedroom;

    @BindView(R.id.post_bathroom)
    TextView postBathroom;

    @BindView(R.id.post_wifi)
    ImageView postWifi;

    @BindView(R.id.linear_wifi)
    LinearLayout linearWifi;

    @BindView(R.id.post_lift)
    ImageView postLift;

    @BindView(R.id.linear_lift)
    LinearLayout linearLift;

    @BindView(R.id.post_parking)
    ImageView postParking;

    @BindView(R.id.linear_parking)
    LinearLayout linearParking;

    @BindView(R.id.post_gas)
    ImageView postGas;

    @BindView(R.id.linear_gas)
    LinearLayout linearGas;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    @BindView(R.id.post_address)
    TextView postAddress;

    @BindView(R.id.linear_location)
    LinearLayout linearLocation;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    @BindView(R.id.nest_scroll)
    NestedScrollView nestScroll;

    private RoomInteractionListener listener;

    private RoomDetailsData roomDetailsData;

    public RoomDetailsView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_room_details_view, this);
        ButterKnife.bind(this);
    }

    public void bindData(RoomDetailsData mRoomDetails) {
        toolbar.setTitle(String.format("\u20B9 %s", mRoomDetails.getPostRent()));
        tvTitle.setText(mRoomDetails.getPostTitle());
        tvAddress.setText(mRoomDetails.getPostAddress());
        postAddress.setText(mRoomDetails.getPostAddress());
        tvCity.setText(String.format("%s, %s", mRoomDetails.getPostCity(), mRoomDetails.getPostZip()));
        Utils.loadPgImage(mRoomDetails.getImage(), backdrop, getContext());
        tvDescription.setText(mRoomDetails.getPostInfo());
        postBedroom.setText(String.format("%s Bedrooms", mRoomDetails.getPostBedrooms()));
        postBathroom.setText(String.format("%s Bathrooms", mRoomDetails.getPostBathrooms()));
        postAvailable.setText(String.format("%s Persons", mRoomDetails.getPostPer()));
        postType.setText(mRoomDetails.getPostPropertyType());

        btnType.setText(mRoomDetails.isPostForGirls() ? "Girls" : "Boys");
        linearWifi.setVisibility(mRoomDetails.isWifiAvailable() ? VISIBLE : GONE);
        linearGas.setVisibility(mRoomDetails.isGasLineAvailable() ? VISIBLE : GONE);
        linearLift.setVisibility(mRoomDetails.isLiftAvailable() ? VISIBLE : GONE);
        linearParking.setVisibility(mRoomDetails.isParkingAvailable() ? VISIBLE : GONE);
    }


    @OnClick(R.id.linear_location)
    void onViewLocation() {
        if (roomDetailsData != null && listener != null)
            listener.onDirection(roomDetailsData);
    }

    @Override
    public void display(RoomDetailsData roomDetailsData) {
        this.roomDetailsData = roomDetailsData;
        bindData(roomDetailsData);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(VISIBLE);
        appbar.setVisibility(GONE);
        nestScroll.setVisibility(GONE);

    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
        appbar.setVisibility(VISIBLE);
        nestScroll.setVisibility(VISIBLE);
    }

    @Override
    public void attach(RoomInteractionListener listener) {
        this.listener = listener;
    }

    @Override
    public void detach(RoomInteractionListener listener) {
        listener = null;
    }

    @OnClick(R.id.btn_get_details)
    public void onViewClicked() {
        Intent intent = new Intent(getContext(), PGBookingActivity.class);
        getContext().startActivity(intent);
    }

    @OnClick(R.id.fab_share)
    public void onShare() {
        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Let me recommend you this application  " + "https://play.google.com/store/apps/details?id=" + getContext().getPackageName());
        try {
            getContext().startActivity(whatsappIntent);
        } catch (android.content.ActivityNotFoundException ex) {
        }
    }
}
