package com.app.pgbooking.ui.girlsroom.view;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.app.pgbooking.R;
import com.app.pgbooking.ui.boysroom.adapter.BoysRoomDataAdapter;
import com.app.pgbooking.ui.girlsroom.adapter.GirlsRoomAdapter;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;
import com.app.pgbooking.widget.EmptyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gautam on 21/04/18.
 */

public class GirlsRoomView extends LinearLayout implements GirlsRoomDisplayer {

    private final GirlsRoomAdapter mGirlsRoomAdapter;

    @BindView(R.id.pg_recycler_view)
    EmptyRecyclerView pgRecyclerView;

    @BindView(R.id.empty_view)
    LinearLayout emptyView;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private PgInteractionListener pgInteractionListener;

    public GirlsRoomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        mGirlsRoomAdapter = new GirlsRoomAdapter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_pg_recycler_view, this);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        pgRecyclerView.setLayoutManager(layoutManager);
        pgRecyclerView.setAdapter(mGirlsRoomAdapter);
        pgRecyclerView.setEmptyView(emptyView);

    }

    @Override
    public void display(RoomDataResponse roomDataResponse) {
        mGirlsRoomAdapter.update(roomDataResponse.getData());
    }

    @Override
    public void addToDisplay(RoomData roomData) {
        mGirlsRoomAdapter.add(roomData);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(GONE);
    }

    @Override
    public void attach(GirlsRoomDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = pgInteractionListener;
        mGirlsRoomAdapter.attach(pgInteractionListener);
    }

    @Override
    public void detach(GirlsRoomDisplayer.PgInteractionListener pgInteractionListener) {
        mGirlsRoomAdapter.detach(pgInteractionListener);
        this.pgInteractionListener = null;
    }
}
