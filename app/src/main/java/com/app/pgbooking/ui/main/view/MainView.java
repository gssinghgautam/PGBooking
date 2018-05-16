package com.app.pgbooking.ui.main.view;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.app.pgbooking.R;
import com.app.pgbooking.Utils;
import com.app.pgbooking.ui.boysroom.BoysRoomFragment;
import com.app.pgbooking.ui.girlsroom.GirlsRoomFragment;
import com.app.pgbooking.ui.main.MainActivity;
import com.app.pgbooking.ui.main.ViewPageFragment;
import com.app.pgbooking.ui.main.adapter.TabPageAdapter;
import com.app.pgbooking.ui.main.adapter.ViewPagerAdapter;
import com.app.pgbooking.ui.pgrooms.model.RoomData;
import com.app.pgbooking.ui.pgrooms.model.RoomDataResponse;
import com.app.pgbooking.ui.user.data_model.User;
import com.google.gson.GsonBuilder;
import com.rd.PageIndicatorView;

import java.io.IOException;
import java.io.InputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainView extends CoordinatorLayout implements MainDisplayer {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.container)
    FrameLayout container;

    @BindView(R.id.tabs)
    TabLayout tabs;

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;

    @BindView(R.id.appbar)
    AppBarLayout appbar;

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    @BindView(R.id.logout_view)
    NavigationView logoutView;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.backdrop_viewpager)
    ViewPager backdropViewpager;

    @BindView(R.id.pageIndicatorView)
    PageIndicatorView pageIndicatorView;

    private CircleImageView profileImageView;
    private TextView nameTextView;
    private TextView emailTextView;

    private DrawerActionListener drawerActionListener;
    private NavigationActionListener navigationActionListener;


    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View.inflate(getContext(), R.layout.merge_main_view, this);
        ButterKnife.bind(this);
        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.drawable.ic_menu_hamburger);
        View headerLayout = navigationView.getHeaderView(0);
        profileImageView = headerLayout.findViewById(R.id.profileImageView);
        nameTextView = headerLayout.findViewById(R.id.nameTextView);
        emailTextView = headerLayout.findViewById(R.id.emailTextView);

        showBackdropViewpager();
        showPagerView();
    }

    private void showBackdropViewpager() {
        String jsonData = readJSONFromAsset();
        if (!TextUtils.isEmpty(jsonData)) {
            RoomDataResponse roomDataResponse = new GsonBuilder().create().fromJson(jsonData, RoomDataResponse.class);
            ViewPagerAdapter adapter = new ViewPagerAdapter(((MainActivity) getContext()).getSupportFragmentManager());
            for (RoomData data : roomDataResponse.getData()) {
                adapter.addFragment(ViewPageFragment.newInstance(data));
            }
            backdropViewpager.setAdapter(adapter);
            pageIndicatorView.setViewPager(backdropViewpager);
        }
    }


    public String readJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("pg_data.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


    private void showPagerView() {
        TabPageAdapter adapter = new TabPageAdapter(getContext(), ((MainActivity) getContext()).getSupportFragmentManager());
        adapter.addFragment(BoysRoomFragment.newInstance(), "Boys");
        adapter.addFragment(GirlsRoomFragment.newInstance(), "Girls");
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(2);
        tabs.setupWithViewPager(viewpager);
    }


    @Override
    public void attach(final DrawerActionListener drawerActionListener, NavigationActionListener navigationActionListener) {

        this.drawerActionListener = drawerActionListener;
        this.navigationActionListener = navigationActionListener;

        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

        navigationView.setNavigationItemSelectedListener(navigationItemSelectedListener);
        logoutView.setNavigationItemSelectedListener(navigationItemSelectedListener);
        profileImageView.setOnClickListener(headerClickListener);
        nameTextView.setOnClickListener(headerClickListener);
        emailTextView.setOnClickListener(headerClickListener);
        toolbar.setNavigationOnClickListener(navigationClickListener);
    }

    @Override
    public void detach(DrawerActionListener drawerActionListener, NavigationActionListener navigationActionListener) {
        //drawer.removeDrawerListener();
        navigationView.setNavigationItemSelectedListener(null);
        logoutView.setNavigationItemSelectedListener(null);
        profileImageView.setOnClickListener(null);
        nameTextView.setOnClickListener(null);
        emailTextView.setOnClickListener(null);
        toolbar.setNavigationOnClickListener(null);
    }

    @Override
    public void setTitle(String title) {
        toolbar.setTitle(title);
    }

    @Override
    public void setUser(User user) {
        Utils.loadImageElseWhite(user.getImage(), profileImageView, getContext());
        nameTextView.setText(user.getName());
        emailTextView.setText(user.getEmail());
    }

    @Override
    public void inflateMenu() {
        if (!toolbar.getMenu().hasVisibleItems()) {
            toolbar.inflateMenu(R.menu.fragment_pg_itemlist);

            MenuItem item = toolbar.getMenu().findItem(R.id.nav_map);
        }
    }

    @Override
    public void clearMenu() {
        toolbar.getMenu().clear();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void openDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        drawer.closeDrawer(GravityCompat.START);
    }

    private final NavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            drawerActionListener.onNavigationItemSelected(item);
            return true;
        }
    };

    private final OnClickListener headerClickListener = new OnClickListener() {
        @Override
        public void onClick(View view) {
            drawerActionListener.onHeaderSelected();
        }
    };

    private final OnClickListener navigationClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            navigationActionListener.onHamburgerPressed();
        }
    };
}
