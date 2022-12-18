package com.example.ejercicio11.poqueapi;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.ejercicio11.models.Pokemon;
import com.example.ejercicio11.models.NameList;
import com.example.ejercicio11.models.NameListItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokeAPI {
    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private static PokeApiService service = retrofit.create(PokeApiService.class);

    public static void getNameList(MutableLiveData<List<NameListItem>> nameList){
        Call<NameList> pokeCall = service.getNameList(844, 0);
        pokeCall.enqueue(new Callback<NameList>() {
            @Override
            public void onResponse(@NonNull Call<NameList> call, @NonNull Response<NameList> response) {
                if (response.isSuccessful()) {
                    NameList list = response.body();
                    if (list != null) {
                        nameList.setValue(list.getResults());
                    }

                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<NameList> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }

    public static void getName(String name, MutableLiveData<Pokemon> name2) {
        Call<Pokemon> pokeCall = service.getNameById(name);
        pokeCall.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                if (response.isSuccessful()) {
                    Pokemon p = response.body();
                    if (p != null) {
                        name2.setValue(p);
                    }
                } else {
                    Log.e("QWERTY", " onResponse: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(@NonNull Call<Pokemon> call, @NonNull Throwable t) {
                Log.e("QWERTY", " onFailure: " + t.getMessage());
            }
        });
    }
}
