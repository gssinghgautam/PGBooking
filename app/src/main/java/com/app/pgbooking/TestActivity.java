package com.app.pgbooking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.pgbooking.ui.pgrooms.model.PgData;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        String jsonData = loadJSONFromAsset();

        PgData[] pgData = new GsonBuilder().create().fromJson(jsonData, PgData[].class);

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_PGS);
        for (PgData pgData1 : pgData) {
            ref.push().setValue(pgData1);
        }
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("pg_data.json");
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
}
