package com.caddington.dev.popularmovies.service;

import com.caddington.dev.popularmovies.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieService {


    public static final String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/{ordering}")
    Call<List<Movie>> moviesSorted(@Path("ordering") String ordering, @Query("api_key") String apiKey);

    /*  Implement a static Retrofit builder in the interface itself, as seen in https://zeroturnaround.com/rebellabs/getting-started-with-retrofit-2/
        Chose this rather than building it in MainActivity to further abstract network operations from the activity itself.
     */
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
