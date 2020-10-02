package com.example.chuck01;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.textView);
        NetworkService.getInstance().
                getJSONApi().
                getPostWithID(1).
                enqueue(new Callback<Value>() {
            @Override
            public void onResponse(@NonNull Call<Value> call, @NonNull  Response<Value> response) {
                Value value = response.body();
                textView.append(value.getJoke() + "\n");
            }

            @Override
            public void onFailure(@NonNull Call<Value> call, @NonNull Throwable t) {
                textView.append("error");
                t.fillInStackTrace();
            }
        });
    }
}