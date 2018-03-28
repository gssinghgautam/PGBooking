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
import com.app.pgbooking.ui.pgrooms.model.PgData;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gautam on 27/03/18.
 */

public class PgItemView extends RelativeLayout {

    @BindView(R.id.iv_pg)
    ImageView ivPg;

    @BindView(R.id.txt_pg_name)
    TextView txtPgName;

    @BindView(R.id.tv_non_ac_price)
    TextView tvNonAcPrice;

    @BindView(R.id.tv_ac_price)
    TextView tvAcPrice;

    @BindView(R.id.tv_address)
    TextView tvAddress;

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

    public void display(final PgData pgData) {
        Utils.loadPgImage(pgData.getThumbnail(), ivPg, getContext());
        txtPgName.setText(pgData.getName());
        tvAddress.setText(pgData.getAddress());
        tvNonAcPrice.setText(String.format(Locale.getDefault(), "\u20B9 %s", pgData.getRentNonAc()));
        tvAcPrice.setText(String.format(Locale.getDefault(), "\u20B9 %s", pgData.getRentAc()));
    }
}
