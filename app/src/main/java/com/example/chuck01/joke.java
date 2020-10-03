package com.example.chuck01;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
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

public class joke extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        textView = findViewById(R.id.textView);
    }

    public void onClick(View view ) {
        EditText valJokes = (EditText) findViewById(R.id.valJokes);
        String val = valJokes.getText().toString();
        int i = Integer.parseInt(val);
        for (int j = 1; j <= i; j++) {
            NetworkService.getInstance().
                    getJSONApi().
                    getPostWithID(j).
                    enqueue(new Callback<Post>() {
                        @Override
                        public void onResponse(@NonNull Call<Post> call, @NonNull  Response<Post> response) {
                            Post post = response.body();
                            textView.append(post.getValue().getJoke() + "\n");
                        }

                        @Override
                        public void onFailure(@NonNull Call<Post> call, @NonNull Throwable t) {
                            textView.append("error");
                            t.fillInStackTrace();
                        }
                    });

        }

    }
}
