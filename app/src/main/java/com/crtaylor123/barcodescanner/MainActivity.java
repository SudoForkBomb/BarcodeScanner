package com.crtaylor123.barcodescanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new BarcodeDetailsFragment(), "detailsFragment")
                    .commit();

            BarcodeDetailsFragment detailsFragment =  (BarcodeDetailsFragment) getSupportFragmentManager().findFragmentByTag("detailsFragment");
            //transaction.replace(R.id.fragment_container, detailsFragment);
            //transaction.commit();

        }

}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onDetailFragmentInteraction(){
        //CameraFragment cameraFragment =  (CameraFragment) getSupportFragmentManager().findFragmentById(R.id.camera_fragment);

        CameraFragment newFragment = new CameraFragment();
        //Bundle args = new Bundle();
        //args.putString("upc", barcodeValues);
        //newFragment.setArguments(args);
        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack so the user can navigate back
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, newFragment);
        transaction.addToBackStack("detailsFragment");
        transaction.commit();
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
        Bundle args =  new Bundle();
        args.putString("upc", string);
        FragmentManager fragmentManager =  getSupportFragmentManager();
        if(fragmentManager.getBackStackEntryCount() > 0){
            fragmentManager.popBackStack();
        }

    }
}


