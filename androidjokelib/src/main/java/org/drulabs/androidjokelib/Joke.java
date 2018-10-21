package org.drulabs.androidjokelib;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Joke {
    private String title;
    private String text;
    private String remark;

    private Joke(String title, String text, String remark) {
        this.title = title;
        this.text = text;
        this.remark = remark;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getRemark() {
        return remark;
    }

    static Joke createJoke(String title, String text, String remark) {
        return new Joke(title, text, remark);
    }

    static Joke[] createJoke(String jokeJsonArray) throws JSONException {
        JSONArray array = new JSONArray(jokeJsonArray);
        Joke[] jokes = new Joke[array.length()];
        for (int i = 0; i < array.length(); i++) {
            JSONObject jokeJson = array.getJSONObject(i);
            jokes[i] = createJoke(jokeJson.getString("title"), jokeJson.getString("text"), null);
        }
        return jokes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joke joke = (Joke) o;
        return Objects.equals(title, joke.title) &&
                Objects.equals(text, joke.text) &&
                Objects.equals(remark, joke.remark);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, text, remark);
    }
}
