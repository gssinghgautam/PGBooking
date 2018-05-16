package com.app.pgbooking.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.pgbooking.Constants;
import com.app.pgbooking.R;
import com.app.pgbooking.Utils;
import com.app.pgbooking.ui.pgrooms.model.RoomData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by gautam on 21/04/18.
 */

public class ViewPageFragment extends Fragment {

    @BindView(R.id.iv_pg)
    ImageView ivPg;

    @BindView(R.id.tv_rent_price)
    TextView tvRentPrice;

    private RoomData mRoomData;

    Unbinder unbinder;

    public static ViewPageFragment newInstance(RoomData roomData) {
        Bundle args = new Bundle();
        args.putParcelable(Constants.ROOM_DATA, roomData);
        ViewPageFragment fragment = new ViewPageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRoomData = getArguments().getParcelable(Constants.ROOM_DATA);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_card, container, false);
        unbinder = ButterKnife.bind(this, view);
        bindData();
        return view;
    }

    public void bindData() {
        Utils.loadPgImage(mRoomData.getImage(), ivPg, getContext());
        tvRentPrice.setText(String.format("\u20B9 %s", mRoomData.getPostRent()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
