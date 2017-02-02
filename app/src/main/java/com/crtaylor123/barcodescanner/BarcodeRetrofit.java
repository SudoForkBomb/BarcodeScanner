package com.crtaylor123.barcodescanner;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chris on 1/5/2017.
 */

public class BarcodeRetrofit {
    static final String apiKey = "7cc78acb320c8441dcd662d0e014f112";
    String upcString = "Not Working";

    public String getBarcodeInfo(String barcodeInfo) {

        barcodeInfo = "0111222333446";

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.upcdatabase.org/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BarcodeAPI barcodeAPI = retrofit.create(BarcodeAPI.class);
        //Call<UPC> call = barcodeAPI.getBarcodeAPI(apiKey, barcodeInfo);

        Call<UPC> call = barcodeAPI.getBarcodeAPIThree();

        call.enqueue(new Callback<UPC>() {
            @Override
            public void onResponse(Call<UPC> call, Response<UPC> response) {
                int statusCode = response.code();
                UPC upcResults = response.body();
                upcString = upcResults.toString();
                System.out.println(statusCode);
                System.out.println(response.body().toString());

            }

            @Override
            public void onFailure(Call<UPC> call, Throwable t) {
                upcString = t.toString();
            }
        });
        System.out.println(call.toString());
        System.out.println(upcString);

        return upcString;
    }


}
