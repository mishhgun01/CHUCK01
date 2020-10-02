package com.example.chuck01;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONPlaceHolder {
    @GET("jokes/{id}")
    public Call<Value> getPostWithID(@Path("id") int id);
}
