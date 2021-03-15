package com.example.alvarogroverchoquegomezexamenauxliaturaseminario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.adapters.messageAdapter;
import com.example.alvarogroverchoquegomezexamenauxliaturaseminario.intefaces.RetrofitClient;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class newTask extends AppCompatActivity {
    private newTask root = this;
    private Button create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        loadComponents();

    }
    private void loadComponents(){
        create = this.findViewById(R.id.button2);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextInputEditText newTitle = root.findViewById(R.id.textInputLayout);
                TextInputEditText newDescription = root.findViewById(R.id.textInputLayout2);

                String title = newTitle.getText().toString().trim();
                String description = newDescription.getText().toString().trim();


                Call<messageAdapter> call = RetrofitClient
                        .getInstance()
                        .getApi().newTask(title, description);

                call.enqueue(new Callback<messageAdapter>() {
                    @Override
                    public void onResponse(Call<messageAdapter> call, Response<messageAdapter> response) {
                        if (response.body().getMessage().equals("the task was created succesfully")) {

                            Intent intent = new Intent(root, MainActivity.class);
                            root.startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<messageAdapter> call, Throwable t) {
                        Toast.makeText(root, t.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });


            }
        });
    }
}