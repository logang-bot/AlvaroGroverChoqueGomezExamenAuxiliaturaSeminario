package com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static final String BASE_URL = "http://192.168.43.188:8000/";
    private static com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces.RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces.RetrofitClient getInstance(){
        if(mInstance == null){
            mInstance = new com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces.RetrofitClient();
        }
        return mInstance;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
