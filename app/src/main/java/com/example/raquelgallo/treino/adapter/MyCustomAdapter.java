package com.example.raquelgallo.treino.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.model.Movies;

import java.util.ArrayList;

/**
 * Created by Raquel Gallo on 14/12/2017.
 */

public class MyCustomAdapter extends ArrayAdapter<Movies> {

    private ArrayList<Movies> moviesList;
    Context mContext;

    private static class ViewHolder {
        ImageView imgMovie;
        TextView txtTitle;
        TextView txtMovieYear;
    }

    public MyCustomAdapter(ArrayList<Movies> list, Context context) {
        super(context, R.layout.movies_itens, list);
        this.moviesList = list;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Movies movies = getItem(position);
        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.movies_itens, parent, false);
            viewHolder.imgMovie = convertView.findViewById(R.id.img_movies);
            viewHolder.txtTitle = convertView.findViewById(R.id.text_view_title);
            viewHolder.txtMovieYear = convertView.findViewById(R.id.text_view_movie_year);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.imgMovie.setBackgroundResource(movies.getImage(position));
        viewHolder.txtTitle.setText(movies.getTitle());
        viewHolder.txtMovieYear.setText(String.valueOf(movies.getMovieYear()));

        return convertView;
    }
}