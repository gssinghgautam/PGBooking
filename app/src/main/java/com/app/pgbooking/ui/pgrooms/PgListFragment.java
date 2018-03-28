package com.app.pgbooking.ui.pgrooms;

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
import com.app.pgbooking.ui.pgrooms.presenter.PgListPresenter;
import com.app.pgbooking.ui.pgrooms.view.PgDisplayer;

/**
 * Created by gautam on 27/03/18.
 */

public class PgListFragment extends Fragment {

    private PgListPresenter presenter;
    private AndroidPgNavigator navigator;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_pg_fragment, container, false);
        getActivity().setTitle(R.string.pg_title);

        navigator = new AndroidPgNavigator((AppCompatActivity) getActivity(), new AndroidNavigator(getActivity()));
        presenter = new PgListPresenter(
                (PgDisplayer) rootView.findViewById(R.id.pgView),
                Dependencies.INSTANCE.getPgService(),
                navigator,
                Dependencies.INSTANCE.getLoginService(),
                Dependencies.INSTANCE.getUserService()
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
