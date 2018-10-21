package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.remote.EndpointsAsyncTask;

import org.drulabs.androidjokelib.JokeDisplay;


public class MainActivity extends AppCompatActivity {

    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;
    String jokesResult;

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public String getJokesResponse() {
        return jokesResult == null ? "" : jokesResult;
    }

    private View mainLayout;
    private ProgressBar progressIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainLayout = findViewById(R.id.main_layout_holder);
        progressIndicator = findViewById(R.id.main_progress_indicator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
//        String jokeText = JokeFetcher.getRandomJoke();
//        Intent jokeActivityIntent = new Intent(this, JokeDisplay.class);
//        jokeActivityIntent.putExtra(JokeDisplay.EXTRA_JOKE_TEXT, jokeText);
//        jokeActivityIntent.putExtra(JokeDisplay.EXTRA_JOKE_TITLE, "Batman");
//        jokeActivityIntent.putExtra(JokeDisplay.EXTRA_JOKE_REMARK, "No remarks");
//        startActivity(jokeActivityIntent);

        showLoading();
        // set idling to false as we are fetching jokes
        if (mIdlingResource != null) {
            mIdlingResource.setIdleState(false);
        }

        new EndpointsAsyncTask(new Listener() {
            @Override
            public void onResult(String result) {

                if (!isDestroyed()) {
                    hideLoading();
                    Intent jokeActivityIntent = new Intent(MainActivity.this, JokeDisplay.class);
                    jokeActivityIntent.putExtra(JokeDisplay.EXTRA_JOKE_TEXT, result);
                    startActivity(jokeActivityIntent);
                    jokesResult = result;
                    if (mIdlingResource != null) {
                        mIdlingResource.setIdleState(true);
                    }
                }

            }
        }).execute("jokes");
    }

    private void showLoading() {
        mainLayout.setAlpha(0.3f);
        progressIndicator.setVisibility(View.VISIBLE);
    }

    private void hideLoading() {
        mainLayout.setAlpha(1.0f);
        progressIndicator.setVisibility(View.GONE);
    }

    public interface Listener {
        void onResult(String result);
    }

}
