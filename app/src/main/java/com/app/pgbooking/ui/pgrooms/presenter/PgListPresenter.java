package com.app.pgbooking.ui.pgrooms.presenter;

import android.os.Bundle;

import com.app.pgbooking.Constants;
import com.app.pgbooking.database.DatabaseResult;
import com.app.pgbooking.navigation.AndroidPgNavigator;
import com.app.pgbooking.ui.login.service.LoginService;
import com.app.pgbooking.ui.pgrooms.model.PgData;
import com.app.pgbooking.ui.pgrooms.model.PgDataSet;
import com.app.pgbooking.ui.pgrooms.services.PgService;
import com.app.pgbooking.ui.pgrooms.view.PgDisplayer;
import com.app.pgbooking.ui.user.service.UserService;

import rx.Subscriber;
import rx.Subscription;

/**
 * Created by gautam on 27/03/18.
 */

public class PgListPresenter {

    private final PgDisplayer pgDisplayer;
    private final LoginService loginService;
    private final UserService userService;
    private final PgService pgService;
    private AndroidPgNavigator navigator;

    private Subscription subscription;

    public PgListPresenter(
            PgDisplayer pgDisplayer,
            PgService pgService,
            AndroidPgNavigator navigator,
            LoginService loginService,
            UserService userService) {
        this.pgDisplayer = pgDisplayer;
        this.pgService = pgService;
        this.navigator = navigator;
        this.loginService = loginService;
        this.userService = userService;
    }

    public void startPresenting() {
        pgDisplayer.attach(interactionListener);

        subscription = pgService.getPgDataSet()
                .subscribe(pgDataSetDatabaseResult);
    }

    private Subscriber<DatabaseResult<PgDataSet>> pgDataSetDatabaseResult = new Subscriber<DatabaseResult<PgDataSet>>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(DatabaseResult<PgDataSet> pgDataSetDatabaseResult) {
            if (pgDataSetDatabaseResult.isSuccess()) {
                pgDisplayer.display(pgDataSetDatabaseResult.getData());
            }
        }
    };

    public void stopPresenting() {
        pgDisplayer.detach(interactionListener);
        subscription.unsubscribe();

    }

    private final PgDisplayer.PgInteractionListener interactionListener = new PgDisplayer.PgInteractionListener() {
        @Override
        public void onPgSelected(PgData pgData) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(Constants.PG_EXTRA, pgData);
            navigator.toSelectedPg(bundle);
        }
    };
}
