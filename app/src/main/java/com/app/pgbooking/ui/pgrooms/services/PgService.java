package com.app.pgbooking.ui.pgrooms.services;

import com.app.pgbooking.database.DatabaseResult;
import com.app.pgbooking.ui.pgrooms.model.PgDataSet;

import rx.Observable;

/**
 * Created by gautam on 27/03/18.
 */

public interface PgService {

    Observable<DatabaseResult<PgDataSet>> getPgDataSet();


}
