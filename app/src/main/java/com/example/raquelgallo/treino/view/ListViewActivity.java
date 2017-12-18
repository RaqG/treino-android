package com.example.raquelgallo.treino.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.adapter.MyCustomAdapter;
import com.example.raquelgallo.treino.model.Movies;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Raquel Gallo on 14/12/2017.
 */

public class ListViewActivity extends AppCompatActivity {

    @BindView(R.id.list_view)
    public ListView listView;

    ArrayList<Movies> dataMovies;

    private static MyCustomAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dataMovies = addFilmes();

        adapter = new MyCustomAdapter(dataMovies, this);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Movies movie = dataMovies.get(position);

                Snackbar.make(view, movie.getTitle() + "\n" + movie.getMovieYear(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();
            }
        });
    }

    private ArrayList<Movies> addFilmes() {
        ArrayList list = new ArrayList();
        list.add(new Movies(1, "Piratas do Caribe", 2001));
        list.add(new Movies(2, "O Senhor dos Anéis", 2001));
        list.add(new Movies(3, "Jogos Vorazes", 2014));
        list.add(new Movies(4, "Star Wars", 2017));
        list.add(new Movies(5, "Star Trek", 2016));
        return list;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}