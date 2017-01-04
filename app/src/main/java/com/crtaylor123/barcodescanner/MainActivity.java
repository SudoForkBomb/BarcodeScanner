package com.crtaylor123.barcodescanner;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button);
        ImageView myImageView = (ImageView) findViewById(R.id.imgview);
        final TextView txtView = (TextView) findViewById(R.id.txtContent);
        final SurfaceView cameraView = (SurfaceView) findViewById(R.id.camera_view);

        Bitmap myBitmap = BitmapFactory.decodeResource(
                getApplicationContext().getResources(),
                R.drawable.puppy);
        myImageView.setImageBitmap(myBitmap);


        /*
        Detects the barcodes. Detects all types of barcodes by default. Use setBarcodeFormats to specify.
         */
        final BarcodeDetector barcodeDetector = new BarcodeDetector.Builder(
                getApplicationContext())
                .build();
        /*
        Fetches a stream of images from the device's camera and displays them in the SurfaceView, cameraView.
        You can adjust the dimensions of the camera preview using the setRequestedPreviewSize method.
         */
        final CameraSource cameraSource = new CameraSource.Builder(
                getApplicationContext(), barcodeDetector)
                .setRequestedPreviewSize(640, 480)
                .build();

        /*
        A callback to the SurfaceHolder of the SurfaceView so that you know when you can start drawing the preview frames.
         */
        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    cameraSource.start(cameraView.getHolder());
                } catch (IOException e) {
                    Log.e("CAMERA SOURCE", e.getMessage());
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();
            }
        });

        /*
        The easiest way to start is to operate on a single frame only.
        Creates a frame using the myBitmap
         */
        Frame frame = new Frame.Builder()
                .setBitmap(myBitmap)
                .build();

        /*
        The detect method for barcodeDetector generates a SparseArray that contains all the barcodes detected in the photo.
         */
        final SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);





        /*
        Tells barcodeDetector what it should do when it detects a QR code.
         */
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
                                         @Override
                                         public void release() {

                                         }

                                         @Override
                                         public void receiveDetections(Detector.Detections<Barcode> detections) {
                                             final SparseArray<Barcode> barcodes = detections.getDetectedItems();

                                             /*
                                            Check if at least one barcode was detected
                                             */
                                             if(barcodes.size() != 0){

                                                /*
                                                Display the barcode's message in txtView
                                                 */
                                                 txtView.post(new Runnable() {
                                                     @Override
                                                     public void run() {
                                                         txtView.setText(
                                                                 barcodes.valueAt(0).displayValue
                                                         );
                                                     }
                                                 });
                                             }

                                         }
                                     }
        );




        /*
        Frame frame = new Frame.Builder().setBitmap(myBitmap).build();
        SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);
        Barcode thisCode = barcodes.valueAt(0);
        txtView.setText(thisCode.rawValue);
        */


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
