package com.app.pgbooking.ui.girlsroom;

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
import com.app.pgbooking.ui.girlsroom.presenter.GirlsRoomPresenter;
import com.app.pgbooking.ui.girlsroom.view.GirlsRoomDisplayer;

/**
 * Created by gautam on 20/04/18.
 */

public class GirlsRoomFragment extends Fragment {

    private GirlsRoomPresenter presenter;
    private AndroidPgNavigator navigator;

    public static GirlsRoomFragment newInstance() {
        Bundle args = new Bundle();
        GirlsRoomFragment fragment = new GirlsRoomFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_girls_room, container, false);
        getActivity().setTitle(R.string.pg_title);

        navigator = new AndroidPgNavigator((AppCompatActivity) getActivity(), new AndroidNavigator(getActivity()));
        presenter = new GirlsRoomPresenter(
                (GirlsRoomDisplayer) rootView.findViewById(R.id.pgView),
                Dependencies.INSTANCE.getGirlsRoomService(),
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
