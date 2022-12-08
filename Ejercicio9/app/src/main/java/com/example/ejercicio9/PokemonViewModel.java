package com.example.ejercicio9;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class PokemonViewModel extends AndroidViewModel {
    Executor executor;
    SimuladorPokemon simulador;
    Pokemon amarillo;
    Pokemon verde;
    MutableLiveData<Pokemon> datosPokemonAmarillo = new MutableLiveData<>();
    MutableLiveData<Pokemon> datosPokemonVerde = new MutableLiveData<>();

    public PokemonViewModel(@NonNull Application application) {
        super(application);
        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorPokemon();
    }

    public void verificarVerde(String nombre, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        verde = new Pokemon(nombre, hp, ataque, defensa, ataqueEspecial, defensaEspecial);
        datosPokemonVerde.postValue(verde);
    }

    public void verificarAmarillo(String nombre, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        amarillo = new Pokemon(nombre, hp, ataque, defensa, ataqueEspecial, defensaEspecial);
        datosPokemonAmarillo.postValue(amarillo);
    }

    public void atacarVerde(int hp) {
        executor.execute(new Runnable() {
            @Override
            public void run() {

                simulador.atacarVerde(solicitud, new SimuladorHipoteca.Callback() {

                });
            }
        });
        verde.setHp(hp);
        datosPokemonVerde.postValue(verde);
    }

    public void atacarAmarillo(int hp) {
        executor.execute(new Runnable() {
            @Override
            public void run() {

                simulador.calcular(solicitud, new SimuladorHipoteca.Callback() {

                });
            }
        });
        amarillo.setHp(hp);
        datosPokemonVerde.postValue(amarillo);
    }
}
