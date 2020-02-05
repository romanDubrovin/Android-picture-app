package com.rom.testpicapp.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {

    private static final String BASE_URL = "https://api.github.com";
    private static Retrofit retrofit;

    public static Retrofit getNetworkService() {
        if (retrofit == null) {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        }

        return retrofit;
    }

    public static NetworkApi createService() {
        return getNetworkService().create(NetworkApi.class);
    }

}