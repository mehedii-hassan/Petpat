package com.example.petpatandroidappdemo.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {

    public static Retrofit retrofit =null;
    public static PhotoServiceApi getService(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.unsplash.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(PhotoServiceApi.class);
    }
   /* public static PhotoServiceApi getService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.unsplash.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PhotoServiceApi.class);
    }*/
}
