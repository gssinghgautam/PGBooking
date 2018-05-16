package com.app.pgbooking.ui.girlsroom.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.pgbooking.R;
import com.app.pgbooking.ui.girlsroom.view.GirlsRoomDisplayer;
import com.app.pgbooking.ui.girlsroom.view.GirlsRoomItemViewHolder;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.view.PgItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gautam on 21/04/18.
 */

public class GirlsRoomAdapter extends RecyclerView.Adapter<GirlsRoomItemViewHolder> {

    private List<RoomData> pgDataList;
    private GirlsRoomDisplayer.PgInteractionListener pgInteractionListener;

    public GirlsRoomAdapter() {
        pgDataList = new ArrayList<>();
    }

    public void update(List<RoomData> pgDataList) {
        /*this.conversations = conversations.sortedByDate();*/
        this.pgDataList = pgDataList;
        notifyDataSetChanged();
    }

    public void add(RoomData pgData) {
        this.pgDataList.add(pgData);
        /*this.conversations = this.conversations.sortedByDate();*/
        notifyDataSetChanged();
    }

    @Override
    public GirlsRoomItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pg_item_layout, parent, false);
        return new GirlsRoomItemViewHolder((PgItemView) view);
    }

    @Override
    public void onBindViewHolder(GirlsRoomItemViewHolder holder, int position) {
        RoomData pgData = pgDataList.get(position);
        holder.bind(pgData, clickListener);
    }

    @Override
    public int getItemCount() {
        return (pgDataList != null && !pgDataList.isEmpty()) ? pgDataList.size() : 0;
    }

    public void attach(GirlsRoomDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = pgInteractionListener;
    }

    public void detach(GirlsRoomDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = null;
    }


    private final GirlsRoomItemViewHolder.PgSelectionListener clickListener = new GirlsRoomItemViewHolder.PgSelectionListener() {

        @Override
        public void onPgSelected(RoomData pgData) {
            pgInteractionListener.onPgSelected(pgData);
        }
    };
}

