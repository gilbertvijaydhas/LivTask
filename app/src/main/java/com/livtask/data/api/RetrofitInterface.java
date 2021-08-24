package com.livtask.data.api;

import com.google.gson.JsonElement;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("json/data.json")
    Call<JsonElement> getEngLang();
}
