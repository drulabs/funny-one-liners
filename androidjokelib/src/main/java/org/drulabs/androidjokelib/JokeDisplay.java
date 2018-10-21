package org.drulabs.androidjokelib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.StackView;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.Arrays;

public class JokeDisplay extends AppCompatActivity {

    public static final String EXTRA_JOKE_TEXT = "joke_text";

    // UI
    StackView jokeStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        Bundle extras = getIntent().getExtras();

        if (extras == null || !extras.containsKey(EXTRA_JOKE_TEXT)) {
            Toast.makeText(this, "Joke not passed properly", Toast.LENGTH_SHORT).show();
            return;
        }

        initializeUI();

        try {
            String jokeJsonArray = extras.getString(EXTRA_JOKE_TEXT);
            Joke[] jokeArray = Joke.createJoke(jokeJsonArray);
            JokeAdapter adapter = new JokeAdapter(new ArrayList<>(Arrays.asList(jokeArray)));
            jokeStack.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }

    private void initializeUI() {
        jokeStack = findViewById(R.id.joke_stack);
    }
}
