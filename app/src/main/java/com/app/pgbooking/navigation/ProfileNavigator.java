
package com.app.pgbooking.navigation;

import android.graphics.Bitmap;
import android.widget.TextView;

import com.app.pgbooking.ui.user.data_model.User;

public interface ProfileNavigator extends Navigator {

    void showInputTextDialog(String hint, TextView textView, User user);

    void showInputPasswordDialog(String hint, User user);

    void showImagePicker();

    void showRemoveDialog();

    void showProgressDialog();

    void dismissProgressDialog();

    void attach(ProfileDialogListener dialogListener);

    void detach(ProfileDialogListener dialogListener);

    interface ProfileDialogListener {

        void onNameSelected(String text, User user);

        void onPasswordSelected(String text);

        void onRemoveSelected();

        void onImageSelected(Bitmap bitmap);

    }

}
