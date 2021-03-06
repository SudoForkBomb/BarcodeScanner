package com.crtaylor123.barcodescanner;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements MainFragment.OnMainFragmentInteractionListener, CameraFragment.OnCameraFragmentInteractionListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new MainFragment(), "mainFragment")
                    .commit();

            MainFragment mainFragment =  (MainFragment) getSupportFragmentManager().findFragmentByTag("mainFragment");
            //transaction.replace(R.id.fragment_container, detailsFragment);
            //transaction.commit();
        }
}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//        String barcodeValues = "";
//        CameraFragment cameraFragment =  (CameraFragment) getSupportFragmentManager().findFragmentById(R.id.camera_fragment);
//
//        //Possibly Check later to see if we are in a two-pane setup. https://developer.android.com/training/basics/fragments/communicating.html
//        if(cameraFragment != null){
//            // If camera frag is available, we're in two-pane layout...
//
//            // Call a method in the CameraFragment to update its content
//            //cameraFragment.updateExample(position);
//        }
//        CameraFragment newFragment = new CameraFragment();
//        //Bundle args = new Bundle();
//        //args.putString("upc", barcodeValues);
//        //newFragment.setArguments(args);
//        // Replace whatever is in the fragment_container view with this fragment,
//        // and add the transaction to the back stack so the user can navigate back
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.fragment_container, newFragment);
//        transaction.addToBackStack("detailsFragment");
//        transaction.commit();

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

    @Override
    public void onCameraFragmentInteraction(String barcodeNum) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.remove(getSupportFragmentManager().findFragmentByTag("cameraFragment"));

        Intent detailIntent = new Intent(this, DetailsActivity.class);
        detailIntent.putExtra("barcodeNum", barcodeNum);
        startActivity(detailIntent);
    }

    @Override
    public void onMainFragmentInteraction() {

        CameraFragment cameraFragment = (CameraFragment) getSupportFragmentManager().findFragmentByTag("cameraFragment");
        //Bundle args = new Bundle();
        //args.putString("upc", barcodeValues);
        //newFragment.setArguments(args);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, new CameraFragment(), "cameraFragment");
        transaction.addToBackStack("mainFragment");
        transaction.commit();

    }
}


