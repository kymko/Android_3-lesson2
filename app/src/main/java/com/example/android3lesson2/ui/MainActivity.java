package com.example.android3lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android3lesson2.R;
import com.example.android3lesson2.adapter.FilmAdapter;
import com.example.android3lesson2.adapter.OnItemClickListener;
import com.example.android3lesson2.data.Films;
import com.example.android3lesson2.remote.filmStorage.FilmStorage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final FilmStorage filmStorage = new FilmStorage();
    private RecyclerView recyclerView;
    private FilmAdapter adapter;
    private List<Films> list = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        adapter = new FilmAdapter();


        filmStorage.getFilm("ebbb6b7c-945c-41ee-a792-de0e43191bd8", new FilmStorage.Callbacks<Films>() {
            @Override
            public void success(Films films) {
                Log.e("tag",films.getTitle());
                list.add(new Films(films.getTitle()));
                adapter.addItems(list);
                recyclerView.setAdapter(adapter);

                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onClick(int position) {
                        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                        intent.putExtra("title",films.getTitle());
                        intent.putExtra("original",films.getOriginalTitle());
                        intent.putExtra("des",films.getDescription());
                        startActivity(intent);
                    }
                });

            }
        });


    }
}