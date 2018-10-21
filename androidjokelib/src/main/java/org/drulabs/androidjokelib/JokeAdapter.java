package org.drulabs.androidjokelib;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class JokeAdapter extends BaseAdapter {

    private List<Joke> jokes;

    JokeAdapter(List<Joke> jokes) {
        this.jokes = new ArrayList<>();
        this.jokes.clear();
        this.jokes.addAll(jokes);
    }

    @Override
    public int getCount() {
        if (jokes == null) {
            return 0;
        }
        return jokes.size();
    }

    @Override
    public Object getItem(int position) {
        return jokes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        JokeHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_joke,
                    parent, false);
            holder = new JokeHolder();
            holder.initializeFrom(convertView);
            convertView.setTag(holder);
        } else {
            holder = (JokeHolder) convertView.getTag();
        }
        holder.bind(position);
        return convertView;
    }

    class JokeHolder {
        TextView tvTitle;
        TextView tvText;
        TextView tvRemark;

        void initializeFrom(@NonNull View convertView) {
            tvTitle = convertView.findViewById(R.id.tv_joke_title);
            tvText = convertView.findViewById(R.id.tv_joke_text);
            tvRemark = convertView.findViewById(R.id.tv_joke_remark);
        }

        void bind(int position) {
            Joke joke = jokes.get(position);
            if (joke != null) {
                if (joke.getText() != null) {
                    tvText.setText(joke.getText());
                }
                if (joke.getTitle() != null) {
                    tvTitle.setText(joke.getTitle());
                }
                if (joke.getRemark() != null) {
                    tvRemark.setText(joke.getRemark());
                    tvRemark.setVisibility(View.VISIBLE);
                }
            }
        }
    }
}
