package com.crtaylor123.barcodescanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.detail_container, new BarcodeDetailsFragment(), "detailFragment")
                .commit();

    }
}
