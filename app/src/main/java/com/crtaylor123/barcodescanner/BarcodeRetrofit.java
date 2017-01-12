package com.crtaylor123.barcodescanner;

import com.google.android.gms.vision.barcode.Barcode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chris on 1/5/2017.
 */

public class BarcodeRetrofit {
    static final String apiKey = "7cc78acb320c8441dcd662d0e014f112";

    public String getBarcodeInfo(String barcodeInfo) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.upcdatabase.org/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BarcodeAPI barcodeAPI = retrofit.create(BarcodeAPI.class);
        System.out.println(barcodeInfo);
//        barcodeAPI.getBarcodeAPI(barcodeInfo, apiKey);
        //Call<UPC> upc = barcodeAPI.getBarcodeAPI(apiKey, barcodeInfo);
        Call<UPC> upc = barcodeAPI.getBarcodeAPITWO(barcodeInfo);
        return upc.toString();
    }
}
