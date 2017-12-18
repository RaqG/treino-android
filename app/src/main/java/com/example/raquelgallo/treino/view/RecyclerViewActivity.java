package com.example.raquelgallo.treino.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.raquelgallo.treino.R;
import com.example.raquelgallo.treino.adapter.MyCustomRecyclerViewAdapter;
import com.example.raquelgallo.treino.model.Cars;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Raquel Gallo on 17/12/2017.
 */

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.list_recycler_view)
    public RecyclerView recyclerView;

    private RecyclerView.LayoutManager layoutManager;

    private List<Cars> listCars;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view);
        getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        listCars = addCars();

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new MyCustomRecyclerViewAdapter(listCars));
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

    private List<Cars> addCars() {
        List<Cars> list = new ArrayList<>();

        list.add(new Cars(1, "Audi", "TT RS Coupé", 2012, "Branca"));
        list.add(new Cars(2, "BMW", "Série 8", 2018, "Azul"));
        list.add(new Cars(3, "Ferrari", "California", 2008, "Vermelha"));
        list.add(new Cars(4, "Lamborghini", "Gallardo", 2013, "Dourada"));

        return list;
    }
}