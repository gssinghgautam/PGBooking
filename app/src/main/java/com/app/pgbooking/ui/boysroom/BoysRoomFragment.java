package com.app.pgbooking.ui.boysroom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.pgbooking.Dependencies;
import com.app.pgbooking.R;
import com.app.pgbooking.navigation.AndroidNavigator;
import com.app.pgbooking.navigation.AndroidPgNavigator;
import com.app.pgbooking.ui.boysroom.presenter.BoysRoomPresenter;
import com.app.pgbooking.ui.boysroom.view.BoysRoomDisplayer;

/**
 * Created by gautam on 20/04/18.
 */

public class BoysRoomFragment extends Fragment {

    private BoysRoomPresenter presenter;
    private AndroidPgNavigator navigator;

    public static BoysRoomFragment newInstance() {
        Bundle args = new Bundle();
        BoysRoomFragment fragment = new BoysRoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_boys_room, container, false);

        navigator = new AndroidPgNavigator((AppCompatActivity) getActivity(), new AndroidNavigator(getActivity()));
        presenter = new BoysRoomPresenter(
                (BoysRoomDisplayer) rootView.findViewById(R.id.pgView),
                Dependencies.INSTANCE.getBoysRoomService(),
                navigator
        );

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.startPresenting();
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.stopPresenting();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
