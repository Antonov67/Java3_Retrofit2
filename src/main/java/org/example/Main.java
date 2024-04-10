package org.example;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    static Retrofit retrofit;
    private static final String BASE_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    public static void main(String[] args) {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
}