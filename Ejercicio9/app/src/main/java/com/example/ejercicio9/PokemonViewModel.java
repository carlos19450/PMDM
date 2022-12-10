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

    public void atacarVerde() {
        SimuladorPokemon.Solicitud solicitudVerde = new SimuladorPokemon.Solicitud(datosPokemonVerde, datosPokemonAmarillo);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.atacarVerde(solicitudVerde, new SimuladorPokemon.Callback() {
                    @Override
                    public void cuandoEsteVerificadoElEquipoPokemonVerde(Pokemon verde) {
                        datosPokemonVerde.postValue(verde);
                    }

                    @Override
                    public void cuandoEsteVerificadoElEquipoPokemonAmarillo(Pokemon verde) {
                        //No hace nada
                    }
                });
            }
        });
        datosPokemonVerde.postValue(verde);
    }

    public void atacarAmarillo() {
        SimuladorPokemon.Solicitud solicitudAmarillo = new SimuladorPokemon.Solicitud(datosPokemonVerde, datosPokemonAmarillo);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.atacarAmarillo(solicitudAmarillo, new SimuladorPokemon.Callback() {
                    @Override
                    public void cuandoEsteVerificadoElEquipoPokemonAmarillo(Pokemon amarillo) {
                        datosPokemonAmarillo.postValue(amarillo);
                    }

                    @Override
                    public void cuandoEsteVerificadoElEquipoPokemonVerde(Pokemon amarillo) {
                        //No hace nada
                    }
                });
            }
        });
        datosPokemonAmarillo.postValue(amarillo);
    }
}
