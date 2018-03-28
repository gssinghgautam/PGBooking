
package com.app.pgbooking.navigation;

public interface MainNavigator {

    void attach();

    void detach();

    void init();

    void toMyBookings();

    void toProfile();

    void toFirstLogin();

    void toGoogleSignOut(int method);

    void toLogin();

    void showProgressDialog();

    void hideProgressDialog();

    Boolean onBackPressed();

}
