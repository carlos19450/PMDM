package com.example.ejercicio11.poqueapi;

import com.example.ejercicio11.models.Pokemon;
import com.example.ejercicio11.models.NameList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    String BASE_URL = "https://pokeapi.co/api/v2/";

    @GET("pokemon/{name}")
    Call<Pokemon> getNameById(@Path("name") String id);

    @GET("pokemon")
    Call<NameList> getNameList(@Query("limit") int limit, @Query("offset") int offset);
}
