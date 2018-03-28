package com.app.pgbooking.ui.pgrooms.view;

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.app.pgbooking.R;
import com.app.pgbooking.ui.pgrooms.adapter.PgRoomsAdapter;
import com.app.pgbooking.ui.pgrooms.model.PgData;
import com.app.pgbooking.ui.pgrooms.model.PgDataSet;
import com.app.pgbooking.widget.EmptyRecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gautam on 27/03/18.
 */

public class PgView extends LinearLayout implements PgDisplayer {

    private final PgRoomsAdapter pgRoomsAdapter;

    @BindView(R.id.pg_recycler_view)
    EmptyRecyclerView pgRecyclerView;

    @BindView(R.id.empty_view)
    LinearLayout emptyView;

    private PgInteractionListener pgInteractionListener;


    public PgView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setOrientation(VERTICAL);
        pgRoomsAdapter = new PgRoomsAdapter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_pg_recycler_view, this);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        pgRecyclerView.setLayoutManager(layoutManager);
        pgRecyclerView.setAdapter(pgRoomsAdapter);
        pgRecyclerView.setEmptyView(emptyView);
        DividerItemDecoration mDividerItemDecoration = new DividerItemDecoration(
                pgRecyclerView.getContext(),
                layoutManager.getOrientation()
        );
        pgRecyclerView.addItemDecoration(mDividerItemDecoration);

    }

    @Override
    public void display(PgDataSet pgDataSet) {
        pgRoomsAdapter.update(pgDataSet.getPgDataList());
    }

    @Override
    public void addToDisplay(PgData pgData) {
        pgRoomsAdapter.add(pgData);
    }

    @Override
    public void attach(PgInteractionListener pgInteractionListener) {
        this.pgInteractionListener = pgInteractionListener;
        pgRoomsAdapter.attach(pgInteractionListener);
    }

    @Override
    public void detach(PgInteractionListener pgInteractionListener) {
        pgRoomsAdapter.detach(pgInteractionListener);
        this.pgInteractionListener = null;
    }
}
