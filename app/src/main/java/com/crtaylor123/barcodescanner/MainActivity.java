package com.crtaylor123.barcodescanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements BarcodeDetailsFragment.OnDetailsFragmentInteractionListener, CameraFragment.OnCameraFragmentInteractionListener {


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

    public String onDetailFragmentInteraction(){
        String barcodeValues = "";
        CameraFragment cameraFragment =  (CameraFragment) getSupportFragmentManager().findFragmentById(R.id.camera_fragment);
        //Possibly Check later to see if we are in a two-pane setup. https://developer.android.com/training/basics/fragments/communicating.html

        if(cameraFragment != null){
            // If camera frag is available, we're in two-pane layout...

            // Call a method in the CameraFragment to update its content
            //cameraFragment.updateExample(position);
        }
        CameraFragment newFragment = new CameraFragment();
        Bundle args = new Bundle();
        args.putString("upc", barcodeValues);
        newFragment.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        transaction.replace(R.id.activity_main_xml, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();


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

    @Override
    public void onCameraFragmentInteraction(String string) {

    }
}


