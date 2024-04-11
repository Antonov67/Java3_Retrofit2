package org.example;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main {

    static Retrofit retrofit;
    private static final String BASE_URL = "https://www.cbr-xml-daily.ru/";
    static Root root;

    public static void main(String[] args) {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        API service = retrofit.create(API.class);
        Call<Root> call = service.getData();

        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.isSuccessful()){
                    root = response.body();
                    System.out.println(root.date);
                    System.out.println(root.valute.byn.name + " " + root.valute.byn.value + Arrow(root.valute.byn.value, root.valute.byn.previous));
                    System.out.println(root.valute.usd.name + " " + root.valute.usd.value+ Arrow(root.valute.usd.value, root.valute.usd.previous));
                    System.out.println(root.valute.eur.name + " " + root.valute.eur.value+ Arrow(root.valute.eur.value, root.valute.eur.previous));
                }

            }

            String Arrow(String v, String p){
                if (Float.parseFloat(v) - Float.parseFloat(p) < 0){
                    return "\u2B07";
                }else if (Float.parseFloat(v) - Float.parseFloat(p) == 0) {
                    return "\u2B0C";
                }else
                    return "\u2B06";
            }

            @Override
            public void onFailure(Call<Root> call, Throwable throwable) {

            }
        });

    }
}