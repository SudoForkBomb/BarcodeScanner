package com.crtaylor123.barcodescanner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MainFragment(), "mainFragment")
                    .commit();

            MainFragment mainFragment =  (MainFragment) getSupportFragmentManager().findFragmentByTag("mainFragment");
            //transaction.replace(R.id.fragment_container, detailsFragment);
            //transaction.commit();

        }
    }
}
