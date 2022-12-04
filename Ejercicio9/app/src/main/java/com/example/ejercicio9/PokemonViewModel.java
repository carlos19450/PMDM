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
    MutableLiveData<String> errorPokemonNombre = new MutableLiveData<>();
    MutableLiveData<Integer> errorPokemonHp = new MutableLiveData<>();
    MutableLiveData<Integer> errorPokemonAtaque = new MutableLiveData<>();
    MutableLiveData<Integer> errorPokemonDefensa = new MutableLiveData<>();
    MutableLiveData<Integer> errorPokemonAtaqueEspecial = new MutableLiveData<>();
    MutableLiveData<Integer> errorPokemonDefensaEspecial = new MutableLiveData<>();

    public PokemonViewModel(@NonNull Application application) {
        super(application);
        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorPokemon();
    }

    public void verificarVerde(String nombre, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        verde = new Pokemon(nombre, hp, ataque, defensa, ataqueEspecial, defensaEspecial);
        final SimuladorPokemon.Solicitud solicitud = new SimuladorPokemon.Solicitud(verde);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.verificar(solicitud, new SimuladorPokemon.Callback() {
                    @Override
                    public void cuandoEsteVerificadoElEquipoPokemon (Pokemon equipoPokemon){
                        datosPokemonVerde.postValue(equipoPokemon);
                    }

                    @Override
                    public void cuandoHayaErrorEnElEquipoPokemon(Pokemon equipoPokemon) {
                        datosPokemonVerde.postValue(equipoPokemon);
                    }
                });
            }
        });
    }
    public void verificarAmarillo(String nombre, int hp, int ataque, int defensa, int ataqueEspecial, int defensaEspecial) {
        amarillo = new Pokemon(nombre, hp, ataque, defensa, ataqueEspecial, defensaEspecial);
        final SimuladorPokemon.Solicitud solicitud = new SimuladorPokemon.Solicitud(amarillo);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                simulador.verificar(solicitud, new SimuladorPokemon.Callback() {
                    @Override
                    public void cuandoEsteVerificadoElEquipoPokemon (Pokemon equipoPokemon){
                        datosPokemonAmarillo.postValue(equipoPokemon);
                    }

                    @Override
                    public void cuandoHayaErrorEnElEquipoPokemon(Pokemon equipoPokemon) {
                        datosPokemonVerde.postValue(equipoPokemon);
                    }
                });
            }
        });
    }
}
