package com.gyk.webserviceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

class NewsAdapter extends BaseAdapter {
    private List<News> newsList;
    private LayoutInflater layoutInflater;

    public NewsAdapter(List<News> newsList, Context context) {
        this.newsList = newsList;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int i) {
        return newsList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view = layoutInflater.inflate(R.layout.news_item,null);

        ImageView imageView =(ImageView) row_view.findViewById(R.id.imageView);
        TextView textView = (TextView) row_view.findViewById(R.id.textView);
        News news = newsList.get(i);
        textView.setText(news.getTitle());
        Picasso.get().load(news.getPhotoUrl()).into(imageView);
        return row_view;
    }
}
