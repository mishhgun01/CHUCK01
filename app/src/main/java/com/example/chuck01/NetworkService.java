package com.example.chuck01;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
  private static NetworkService mInstance;
  private static final String BASE_URL = "https://api.icndb.com/";
  private Retrofit mRetrofit;
  private NetworkService(){
    mRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
  }

  public static NetworkService getInstance(){
    if (mInstance==null){
      mInstance = new NetworkService();
    }
    return mInstance;
  }
  public JSONJokesGet getJSONApi(){
    return mRetrofit.create(JSONJokesGet.class);
  }
}
  