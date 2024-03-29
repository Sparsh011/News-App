package com.example.newsapp.api;

import com.example.newsapp.api.ApiInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class ApiUtilities {
    private static Retrofit retrofit = null;

    public static ApiInterface getApiInterface(){
        if (retrofit == null){
//            Create an object of retrofit
            retrofit = new Retrofit.Builder().baseUrl(ApiInterface.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(ApiInterface.class);
    }
}
