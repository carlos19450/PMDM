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

    public void verificar(Solicitud solicitud, Callback callback) {
        boolean hayError = false;

        if (solicitud.equipoPokemon.getNombre() == null) {
            callback.cuandoHayaErrorEnElEquipoPokemon(null);
            hayError = true;
        }

        if (solicitud.equipoPokemon.getHp() != 0 || solicitud.equipoPokemon.getHp() != 1 || solicitud.equipoPokemon.getHp() != 2 || solicitud.equipoPokemon.getHp() != 3 || solicitud.equipoPokemon.getHp() != 4 || solicitud.equipoPokemon.getHp() != 5 || solicitud.equipoPokemon.getHp() != 6 || solicitud.equipoPokemon.getHp() != 7 || solicitud.equipoPokemon.getHp() != 8 || solicitud.equipoPokemon.getHp() != 9) {
            callback.cuandoHayaErrorEnElEquipoPokemon(null);
            hayError = true;
        }

        if (solicitud.equipoPokemon.getAtaque() != 0 || solicitud.equipoPokemon.getAtaque() != 1 || solicitud.equipoPokemon.getAtaque() != 2 || solicitud.equipoPokemon.getAtaque() != 3 || solicitud.equipoPokemon.getAtaque() != 4 || solicitud.equipoPokemon.getAtaque() != 5 || solicitud.equipoPokemon.getAtaque() != 6 || solicitud.equipoPokemon.getAtaque() != 7 || solicitud.equipoPokemon.getAtaque() != 8 || solicitud.equipoPokemon.getAtaque() != 9) {
            callback.cuandoHayaErrorEnElEquipoPokemon(null);
            hayError = true;
        }

        if (solicitud.equipoPokemon.getDefensa() != 0 || solicitud.equipoPokemon.getDefensa() != 1 || solicitud.equipoPokemon.getDefensa() != 2 || solicitud.equipoPokemon.getDefensa() != 3 || solicitud.equipoPokemon.getDefensa() != 4 || solicitud.equipoPokemon.getDefensa() != 5 || solicitud.equipoPokemon.getDefensa() != 6 || solicitud.equipoPokemon.getDefensa() != 7 || solicitud.equipoPokemon.getDefensa() != 8 || solicitud.equipoPokemon.getDefensa() != 9) {
            callback.cuandoHayaErrorEnElEquipoPokemon(null);
            hayError = true;
        }

        if (solicitud.equipoPokemon.getAtaqueEspecial() != 0 || solicitud.equipoPokemon.getAtaqueEspecial() != 1 || solicitud.equipoPokemon.getAtaqueEspecial() != 2 || solicitud.equipoPokemon.getAtaqueEspecial() != 3 || solicitud.equipoPokemon.getAtaqueEspecial() != 4 || solicitud.equipoPokemon.getAtaqueEspecial() != 5 || solicitud.equipoPokemon.getAtaqueEspecial() != 6 || solicitud.equipoPokemon.getAtaqueEspecial() != 7 || solicitud.equipoPokemon.getAtaqueEspecial() != 8 || solicitud.equipoPokemon.getAtaqueEspecial() != 9) {
            callback.cuandoHayaErrorEnElEquipoPokemon(null);
            hayError = true;
        }

        if (solicitud.equipoPokemon.getDefensaEspecial() != 0 || solicitud.equipoPokemon.getDefensaEspecial() != 1 || solicitud.equipoPokemon.getDefensaEspecial() != 2 || solicitud.equipoPokemon.getDefensaEspecial() != 3 || solicitud.equipoPokemon.getDefensaEspecial() != 4 || solicitud.equipoPokemon.getDefensaEspecial() != 5 || solicitud.equipoPokemon.getDefensaEspecial() != 6 || solicitud.equipoPokemon.getDefensaEspecial() != 7 || solicitud.equipoPokemon.getDefensaEspecial() != 8 || solicitud.equipoPokemon.getDefensaEspecial() != 9) {
            callback.cuandoHayaErrorEnElEquipoPokemon(null);
            hayError = true;
        }

        if(!hayError) {
            callback.cuandoEsteVerificadoElEquipoPokemon(solicitud.equipoPokemon);
        }
    }

}
