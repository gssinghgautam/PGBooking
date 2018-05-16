package com.app.pgbooking.ui.boysroom.view;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.app.pgbooking.R;
import com.app.pgbooking.ui.boysroom.adapter.BoysRoomDataAdapter;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;
import com.app.pgbooking.widget.EmptyRecyclerView;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gautam on 20/04/18.
 */

public class BoysRoomView extends LinearLayout implements BoysRoomDisplayer {

    private final BoysRoomDataAdapter mBoysRoomAdapter;

    @BindView(R.id.pg_recycler_view)
    EmptyRecyclerView pgRecyclerView;

    @BindView(R.id.empty_view)
    LinearLayout emptyView;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private PgInteractionListener pgInteractionListener;


    public BoysRoomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        mBoysRoomAdapter = new BoysRoomDataAdapter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_pg_recycler_view, this);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        pgRecyclerView.setLayoutManager(layoutManager);
        pgRecyclerView.setAdapter(mBoysRoomAdapter);
        pgRecyclerView.setEmptyView(emptyView);

    }

    @Override
    public void display(RoomDataResponse roomDataResponse) {
        List<RoomData> roomDataList = new ArrayList<>();

        String jsonData = readJSONFromAsset();
        if (!TextUtils.isEmpty(jsonData)) {
            RoomDataResponse roomData = new GsonBuilder().create().fromJson(jsonData, RoomDataResponse.class);
            roomDataList.addAll(roomData.getData());
        }
        //roomDataList.addAll(roomDataResponse.getData());

        mBoysRoomAdapter.update(roomDataList);
    }

    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("pg_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    @Override
    public void addToDisplay(RoomData roomData) {
        mBoysRoomAdapter.add(roomData);
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
    public void attach(PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = pgInteractionListener;
        mBoysRoomAdapter.attach(pgInteractionListener);
    }

    @Override
    public void detach(PgInteractionListener pgInteractionListener) {
        mBoysRoomAdapter.detach(pgInteractionListener);
        this.pgInteractionListener = null;
    }
}
