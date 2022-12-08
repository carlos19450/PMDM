package com.example.ejercicio9;

import android.opengl.GLSurfaceView;
import android.os.Debug;
import android.util.Log;

public class SimuladorPokemon {

    public static class Solicitud {
        public Pokemon equipoPokemon;
        public Solicitud(Pokemon equipoPokemon) {
            this.equipoPokemon = equipoPokemon;
        }
    }

    interface Callback {
        void cuandoEsteVerificadoElEquipoPokemon(Pokemon equipoPokemon);
        void cuandoHayaErrorEnElEquipoPokemon(Pokemon equipoPokemon);
    }

    public void calcularAtaque(Solicitud solicitud, Callback callback) {
            callback.cuandoEsteVerificadoElEquipoPokemon(solicitud.equipoPokemon);
    }

}
