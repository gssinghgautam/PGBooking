package com.app.pgbooking.ui.pgrooms.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.pgbooking.R;
import com.app.pgbooking.ui.pgrooms.model.PgData;
import com.app.pgbooking.ui.pgrooms.view.PgDisplayer;
import com.app.pgbooking.ui.pgrooms.view.PgItemView;
import com.app.pgbooking.ui.pgrooms.view.PgItemViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gautam on 27/03/18.
 */

public class PgRoomsAdapter extends RecyclerView.Adapter<PgItemViewHolder> {

    private List<PgData> pgDataList;
    private PgDisplayer.PgInteractionListener pgInteractionListener;

    public PgRoomsAdapter() {
        pgDataList = new ArrayList<>();
    }

    public void update(List<PgData> pgDataList) {
        /*this.conversations = conversations.sortedByDate();*/
        this.pgDataList = pgDataList;
        notifyDataSetChanged();
    }

    public void add(PgData pgData) {
        this.pgDataList.add(pgData);
        /*this.conversations = this.conversations.sortedByDate();*/
        notifyDataSetChanged();
    }

    @Override
    public PgItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pg_item_layout, parent, false);
        return new PgItemViewHolder((PgItemView) view);
    }

    @Override
    public void onBindViewHolder(PgItemViewHolder holder, int position) {
        PgData pgData = pgDataList.get(position);
        holder.bind(pgData, clickListener);
    }

    @Override
    public int getItemCount() {
        return (pgDataList != null && !pgDataList.isEmpty()) ? pgDataList.size() : 0;
    }

    public void attach(PgDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = pgInteractionListener;
    }

    public void detach(PgDisplayer.PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = null;
    }


    private final PgItemViewHolder.PgSelectionListener clickListener = new PgItemViewHolder.PgSelectionListener() {

        @Override
        public void onPgSelected(PgData pgData) {
            pgInteractionListener.onPgSelected(pgData);
        }
    };
}
