package com.crtaylor123.barcodescanner;

import retrofit2.http.GET;

/**
 * Created by chris on 1/5/2017.
 */
public interface BarcodeAPI {
    @GET("/{key}/{id}")
    void getBarcodeAPI(@PATH)

}
