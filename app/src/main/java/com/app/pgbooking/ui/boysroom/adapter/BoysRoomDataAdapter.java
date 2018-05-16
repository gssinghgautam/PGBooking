package com.app.pgbooking.ui.boysroom.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.pgbooking.R;
import com.app.pgbooking.ui.boysroom.view.BoysRoomDisplayer;
import com.app.pgbooking.ui.boysroom.view.BoysRoomItemViewHolder;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.view.PgItemView;

import java.util.ArrayList;
import java.util.List;

public class BoysRoomDataAdapter extends RecyclerView.Adapter<BoysRoomItemViewHolder> {

    private List<RoomData> pgDataList;
    private BoysRoomDisplayer.PgInteractionListener pgInteractionListener;

    public BoysRoomDataAdapter() {
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
    public BoysRoomItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pg_item_layout, parent, false);
        return new BoysRoomItemViewHolder((PgItemView) view);
    }

    @Override
    public void onBindViewHolder(BoysRoomItemViewHolder holder, int position) {
        RoomData pgData = pgDataList.get(position);
        holder.bind(pgData, clickListener);
    }

    @Override
    public int getItemCount() {
        return (pgDataList != null && !pgDataList.isEmpty()) ? pgDataList.size() : 0;
    }

    public void attach(BoysRoomDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = pgInteractionListener;
    }

    public void detach(BoysRoomDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = null;
    }


    private final BoysRoomItemViewHolder.PgSelectionListener clickListener = new BoysRoomItemViewHolder.PgSelectionListener() {

        @Override
        public void onPgSelected(RoomData pgData) {
            pgInteractionListener.onPgSelected(pgData);
        }
    };
}
