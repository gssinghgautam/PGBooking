package com.app.pgbooking.ui.pgrooms.view;

import com.app.pgbooking.ui.pgrooms.model.PgData;
import com.app.pgbooking.ui.pgrooms.model.PgDataSet;

import java.util.List;

/**
 * Created by gautam on 27/03/18.
 */

public interface PgDisplayer {

    void display(PgDataSet pgDataSet);

    void addToDisplay(PgData pgData);

    void attach(PgInteractionListener pgInteractionListener);

    void detach(PgInteractionListener pgInteractionListener);


  public   interface PgInteractionListener {

        void onPgSelected(PgData pgData);

    }
}
