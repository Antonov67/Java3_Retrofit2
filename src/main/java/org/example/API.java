package org.example;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {

    @GET("daily_json.js")
    Call<Root> getData();

}
