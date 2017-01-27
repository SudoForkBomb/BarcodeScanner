package com.crtaylor123.barcodescanner;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnCameraFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CameraFragment#} factory method to
 * create an instance of this fragment.
 */
public class CameraFragment extends Fragment {
    private OnCameraFragmentInteractionListener mListener;


    SurfaceView cameraView;
    BarcodeDetector barcodeDetector;
    CameraSource cameraSource;
    Bitmap myBitmap;

    public CameraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_camera, container, false);
        final Context context = getActivity().getApplicationContext();
        System.out.println("Camera Fragment Context = " + context.toString());

        final TextView txtView = (TextView) rootView.findViewById(R.id.camera_text);

        cameraView = (SurfaceView) rootView.findViewById(R.id.camera_view);

        barcodeDetector = new BarcodeDetector.Builder(context)
                .build();

        if (!barcodeDetector.isOperational()) {
            txtView.setText("Could not set up the detector!");
        }

        cameraSource = new CameraSource.Builder(
                context, barcodeDetector)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setAutoFocusEnabled(true)
                .setRequestedPreviewSize(1920, 1080)
                .setRequestedFps(30.0f)
                .build();

        cameraView.getHolder().addCallback(new SurfaceHolder.Callback() {

            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                try {
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
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
        The detect method for barcodeDetector generates a SparseArray that contains all the barcodes detected in the photo.
         */
        //final SparseArray<Barcode> barcodes = barcodeDetector.detect(frame);

        /*
        Tells barcodeDetector what it should do when it detects a QR code.
         */
//        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
//            @Override
//            public void release() {
//            }
//            @Override
//            public void receiveDetections(Detector.Detections<Barcode> detections) {
//                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
//                //Check if at least one barcode was detected
//                if (barcodes.size() != 0) {
//                    //Display the barcode's message in txtView
//                    txtView.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            txtView.setText(
//                                    new BarcodeRetrofit().getBarcodeInfo(barcodes.valueAt(0).displayValue));
//                            //barcodes.valueAt(0).displayValue);
//                        }
//                    });
//                }
//
//            }
//        });

        String barcodeResult = scanBarcode(barcodeDetector);
        txtView.setText(barcodeResult);

        return rootView;
    }

    public String scanBarcode(BarcodeDetector barcodeDetector){
        final String[] results = {""};
        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {
            }
            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> barcodes = detections.getDetectedItems();
                //Check if at least one barcode was detected

                if (barcodes.size() != 0) {
                    results[0] = barcodes.valueAt(0).displayValue;

                }

            }
        });
        return results[0];
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCameraFragmentInteractionListener) {
            mListener = (OnCameraFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnCameraFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnCameraFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCameraFragmentInteraction(String uri);
    }
}
