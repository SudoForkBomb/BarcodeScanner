package com.crtaylor123.barcodescanner;

import com.google.android.gms.vision.barcode.Barcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by chris on 1/5/2017.
 */

public class BarcodeRetrofit {
    static final String apiKey = "";

    public String getBarcodeInfo(Barcode barcodeInfo) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.upcdatabase.org/json/")
                .build();

        BarcodeAPI barcodeAPI = retrofit.create(BarcodeAPI.class);
        barcodeAPI.getBarcodeAPI(barcodeInfo, apiKey);
        Call<UPC> upc = barcodeAPI.getBarcodeAPI(barcodeInfo, apiKey);
        return upc.toString();
    }
}
