package com.app.pgbooking.ui.booking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.app.pgbooking.R;
import com.app.pgbooking.SendMail;
import com.app.pgbooking.ui.main.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PGBookingActivity extends AppCompatActivity implements SendMail.OnSendMailSuccessListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.edit_name)
    TextInputEditText editName;

    @BindView(R.id.name_input_layout)
    TextInputLayout nameInputLayout;

    @BindView(R.id.edit_email)
    TextInputEditText editEmail;

    @BindView(R.id.email_input_layout)
    TextInputLayout emailInputLayout;

    @BindView(R.id.edit_phone)
    TextInputEditText editPhone;

    @BindView(R.id.phone_input_layout)
    TextInputLayout phoneInputLayout;

    @BindView(R.id.nest_scroll)
    NestedScrollView nestScroll;

    @BindView(R.id.btn_submit)
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgbooking);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editName.getText().toString();
                String email = editEmail.getText().toString();
                String phone = editPhone.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    nameInputLayout.setError("Please enter valid name");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    nameInputLayout.setError("Please enter valid email");
                    return;
                }

                if (TextUtils.isEmpty(phone)) {
                    nameInputLayout.setError("Please enter valid mobile number");
                    return;
                }
                String subject = "Request for PG Booking";
                String message = String.format("Hi %s,\n\n Thank you for showing interest. We have shared your details with the PG owner, you will get a call from owner for more details", name);
                sendEmail(name, email, subject, message);
            }
        });
    }


    private void loadMainView() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void sendEmail(String name, String email, String subject, String message) {
        //Creating SendMail object
        SendMail sm = new SendMail(this, email, subject, message);

        //Executing sendmail to send email
        sm.setOnSendMailSuccessListener(this);
        sm.execute();
    }

    @Override
    public void onSuccess() {
        loadMainView();
    }

    @Override
    public void onFail() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
