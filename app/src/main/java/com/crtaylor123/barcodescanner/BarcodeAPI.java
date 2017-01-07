package com.crtaylor123.barcodescanner;

import com.google.android.gms.vision.barcode.Barcode;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by chris on 1/5/2017.
 */
public interface BarcodeAPI {
    @GET("/{key}/{id}")
    Call<UPC> getBarcodeAPI(@Path("key") Barcode key, @Path("id") String id);


}
