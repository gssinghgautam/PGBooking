
package com.app.pgbooking.ui.main.view;

import android.view.MenuItem;

import com.app.pgbooking.ui.user.data_model.User;

public interface MainDisplayer {

    void attach(DrawerActionListener drawerActionListener, NavigationActionListener navigationActionListener);

    void detach(DrawerActionListener drawerActionListener, NavigationActionListener navigationActionListener);

    void setTitle(String title);

    void setUser(User user);

    void inflateMenu();

    void clearMenu();

    boolean onBackPressed();

    void openDrawer();

    void closeDrawer();

    interface DrawerActionListener {

        void onHeaderSelected();

        void onNavigationItemSelected(MenuItem item);

    }

    interface NavigationActionListener {

        void onHamburgerPressed();

    }
}
