package com.example.chuck01;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.text.Editable;
import android.view.Menu;
import android.widget.ScrollView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void showJokes(View view){
        Intent intent = new Intent(this,joke.class);
        startActivity(intent);
    }
    public void showAPI(View view){
        Intent intent = new Intent(this, APIshow.class);
        startActivity(intent);
    }
}