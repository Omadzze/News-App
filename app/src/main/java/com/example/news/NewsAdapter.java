package com.example.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        News currentNews = getItem(position);

        String date = currentNews.getDate().substring(0, 10);

        TextView titleText = listItemView.findViewById(R.id.titleText);
        titleText.setText(currentNews.getTitle());
        TextView articleText = listItemView.findViewById(R.id.articleText);
        articleText.setText(currentNews.getArticle());
        TextView dateText = listItemView.findViewById(R.id.date);
        dateText.setText(date);
        TextView authorText = listItemView.findViewById(R.id.authorText);
        authorText.setText(currentNews.getAuthor());

        return listItemView;

    }

}
