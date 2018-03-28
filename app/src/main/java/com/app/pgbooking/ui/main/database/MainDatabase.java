package com.app.pgbooking.ui.main.database;

import com.app.pgbooking.ui.pgrooms.model.PgDataSet;

import rx.Observable;

/**
 * Created by gautam on 26/03/18.
 */

public interface MainDatabase {

    Observable<PgDataSet> observePgDataSet();
}
