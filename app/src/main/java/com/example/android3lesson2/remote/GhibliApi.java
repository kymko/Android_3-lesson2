package com.example.android3lesson2.remote;

import com.example.android3lesson2.data.Films;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("films/{id}")
    Call<Films> getFilms(@Path("id")String filmId);

}
