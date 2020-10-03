package com.example.chuck01;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface JSONJokesGet {
  @GET("jokes/{id}")
  public Call<Post> getPostWithID(@Path("id") int id);
}