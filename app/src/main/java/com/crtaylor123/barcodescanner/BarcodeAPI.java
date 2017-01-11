package com.crtaylor123.barcodescanner;

import com.google.android.gms.vision.barcode.Barcode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by chris on 1/5/2017.
 */
public interface BarcodeAPI {

    @GET("{key}/{code}")
    Call<UPC> getBarcodeAPI(@Path("key") String key, @Path("code") String code);


}
