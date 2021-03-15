package com.example.alvarogroverchoquegomezexamenauxliaturaseminario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters.structTask;
import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters.taskAdapter;
import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces.RetrofitClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listT = findViewById(R.id.myTasks);
        Call<ArrayList<structTask>> call = RetrofitClient
                .getInstance()
                .getApi().getAlltasks();
        call.enqueue(new Callback<ArrayList<structTask>>() {
            @Override
            public void onResponse(Call<ArrayList<structTask>> call, Response<ArrayList<structTask>> response) {
                ArrayList<structTask> data = response.body();
                taskAdapter adapter = new taskAdapter(data, getApplicationContext());
                listT.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<structTask>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}