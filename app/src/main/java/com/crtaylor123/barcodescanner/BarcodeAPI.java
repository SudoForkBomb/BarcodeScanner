package com.crtaylor123.barcodescanner;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by chris on 1/5/2017.
 */
public interface BarcodeAPI {

    @GET("{key}/{code}")
    Call<UPC> getBarcodeAPI(@Path("key") String key, @Path("code") String code);

    @GET("7cc78acb320c8441dcd662d0e014f112/{code}")
    Call<UPC> getBarcodeAPITWO(@Path("code") String code);

    @GET("7cc78acb320c8441dcd662d0e014f112/0111222333446")
    Call<UPC> getBarcodeAPIThree();


}
