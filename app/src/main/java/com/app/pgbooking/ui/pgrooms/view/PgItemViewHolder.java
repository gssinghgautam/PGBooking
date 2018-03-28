package com.app.pgbooking.ui.pgrooms.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.app.pgbooking.ui.pgrooms.model.PgData;

/**
 * Created by gautam on 27/03/18.
 */

public class PgItemViewHolder extends RecyclerView.ViewHolder {

    private final PgItemView pgItemView;

    public PgItemViewHolder(PgItemView pgItemView) {
        super(pgItemView);
        this.pgItemView = pgItemView;
    }


    public void bind(final PgData pgData, final PgSelectionListener listener) {
        pgItemView.display(pgData);
        pgItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPgSelected(pgData);
            }
        });
    }

    public interface PgSelectionListener {
        void onPgSelected(PgData pgData);
    }
}
