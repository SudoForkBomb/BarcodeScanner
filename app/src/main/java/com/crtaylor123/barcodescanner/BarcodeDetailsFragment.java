package com.crtaylor123.barcodescanner;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnDetailsFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BarcodeDetailsFragment extends Fragment {

    private OnDetailsFragmentInteractionListener mListener;
    Button btn;
    TextView txtView;
    TextView numberTxtView;
    TextView itemNameTxtView;
    TextView aliasTxtView;
    TextView descriptionTxtView;
    TextView avgPriceTxtView;
    TextView rateUpTxtView;
    TextView rateDownTxtView;

    public BarcodeDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_barcode_details, container, false);
        btn = (Button) rootView.findViewById(R.id.button);
        txtView = (TextView) rootView.findViewById(R.id.txtContent);
        numberTxtView = (TextView) rootView.findViewById(R.id.numberTxtView);
        itemNameTxtView = (TextView) rootView.findViewById(R.id.itemNameTxtView);
        aliasTxtView = (TextView) rootView.findViewById(R.id.aliasTxtView);
        descriptionTxtView = (TextView) rootView.findViewById(R.id.descriptionTxtView);
        avgPriceTxtView = (TextView) rootView.findViewById(R.id.avgPriceTxtView);
        rateUpTxtView = (TextView) rootView.findViewById(R.id.rateUpTxtView);
        rateDownTxtView = (TextView) rootView.findViewById(R.id.rateDownTxtView);

        return rootView;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDetailsFragmentInteractionListener) {
            mListener = (OnDetailsFragmentInteractionListener) context;
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
    public interface OnDetailsFragmentInteractionListener {
        // TODO: Update argument type and name
        void onDetailFragmentInteraction();

    }
}
