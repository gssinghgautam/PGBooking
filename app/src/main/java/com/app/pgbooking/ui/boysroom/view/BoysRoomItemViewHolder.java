package com.app.pgbooking.ui.boysroom.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.view.PgItemView;

/**
 * Created by gautam on 20/04/18.
 */

public class BoysRoomItemViewHolder extends RecyclerView.ViewHolder {


    private final PgItemView pgItemView;

    public BoysRoomItemViewHolder(PgItemView pgItemView) {
        super(pgItemView);
        this.pgItemView = pgItemView;
    }


    public void bind(final RoomData pgData, final PgSelectionListener listener) {
        pgItemView.display(pgData);
        pgItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPgSelected(pgData);
            }
        });
    }

    public interface PgSelectionListener {
        void onPgSelected(RoomData pgData);
    }

}
