package com.crtaylor123.barcodescanner;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements BarcodeDetailsFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public String onFragmentInteraction(){
        String barcodeValues = "";
        CameraFragment cameraFragment =  (CameraFragment) getSupportFragmentManager().findFragmentById(R.id.camera_fragment);
        //Possibly Check later to see if we are in a two-pane setup. https://developer.android.com/training/basics/fragments/communicating.html

        CameraFragment newFragment = new CameraFragment();

        Bundle args = new Bundle();


        return barcodeValues;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItemThatWasSelected = item.getItemId();
        if(menuItemThatWasSelected == R.id.action_search){
            Context context = MainActivity.this;
            String message = "Search clicked";
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

}


