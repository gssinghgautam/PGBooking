package com.app.pgbooking.ui.pgrooms.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.pgbooking.R;
import com.app.pgbooking.Utils;
import com.app.pgbooking.ui.pgrooms.model.RoomData;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gautam on 27/03/18.
 */

public class PgItemView extends RelativeLayout {


    @BindView(R.id.iv_pg)
    ImageView ivPg;

    @BindView(R.id.tv_rent_price)
    TextView tvRentPrice;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_number_rooms)
    TextView tvNumberRooms;

    @BindView(R.id.tv_number_bathroom)
    TextView tvNumberBathroom;

    private int layoutResId;

    public PgItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] attrsArray = {
                    android.R.attr.layout
            };
            TypedArray array = context.obtainStyledAttributes(attrs, attrsArray);
            layoutResId = array.getResourceId(0, R.layout.merge_pg_item_view);
            array.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), layoutResId, this);
        ButterKnife.bind(this);
    }

    public void display(final RoomData pgData) {
        Utils.loadPgImage(pgData.getImage(), ivPg, getContext());
        tvTitle.setText(pgData.getPostTitle());
        tvAddress.setText(String.format("%s, %s", pgData.getPostAddress(), pgData.getPostCity()));
        tvRentPrice.setText(String.format("\u20B9 %s", pgData.getPostRent()));
        tvNumberBathroom.setText(pgData.getPostBathrooms());
        tvNumberRooms.setText(pgData.getPostBedrooms());
    }
}
