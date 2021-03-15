package com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces;

import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters.messageAdapter;
import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters.structTask;


import java.util.ArrayList;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Api {
    @GET("allTasks")
    Call<ArrayList<structTask>> getAlltasks();

    @FormUrlEncoded
    @POST("newTask")
    Call<messageAdapter> newTask(@Field("title") String titleT, @Field("description") String descT);

    @DELETE("delTask")
    Call<messageAdapter> delUser(@Query("id") String id);
}



