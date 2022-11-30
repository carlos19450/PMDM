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

    MutableLiveData<Double> cuota = new MutableLiveData<>();

    public PokemonViewModel(@NonNull Application application) {
        super(application);

        executor = Executors.newSingleThreadExecutor();
        simulador = new SimuladorPokemon();
    }

    public void calcular(double capital, int plazo) {

        final SimuladorPokemon.Solicitud solicitud = new SimuladorPokemon.Solicitud(capital, plazo);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                double cuotaResultante = simulador.calcular(solicitud);
                cuota.postValue(cuotaResultante);
            }
        });
    }
}
