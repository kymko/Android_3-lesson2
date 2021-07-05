package com.example.android3lesson2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.android3lesson2.R;
import com.example.android3lesson2.data.Films;
import com.example.android3lesson2.remote.filmStorage.FilmStorage;

public class MainActivity extends AppCompatActivity {

    private final FilmStorage filmStorage = new FilmStorage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filmStorage.getFilm("ebbb6b7c-945c-41ee-a792-de0e43191bd8", new FilmStorage.Callbacks<Films>() {
            @Override
            public void success(Films films) {
                Log.e("tag",films.getTitle());

            }
        });


    }
}