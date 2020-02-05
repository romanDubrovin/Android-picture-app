package com.rom.testpicapp.net;

import com.rom.testpicapp.net.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {

    @GET("/search/users?q=location:russia")
    Call<Result> getUserList();
}
