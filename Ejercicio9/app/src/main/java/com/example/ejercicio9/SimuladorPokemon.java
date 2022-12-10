package com.example.ejercicio9;

import androidx.lifecycle.MutableLiveData;

public class SimuladorPokemon {

    public static class Solicitud {
        public MutableLiveData<Pokemon> datosPokemonVerde;
        public MutableLiveData<Pokemon> datosPokemonAmarillo;
        public Solicitud(MutableLiveData<Pokemon> datosPokemonVerde, MutableLiveData<Pokemon> datosPokemonAmarillo) {
            this.datosPokemonVerde = datosPokemonVerde;
            this.datosPokemonAmarillo = datosPokemonAmarillo;
        }
    }

    interface Callback {
        void cuandoEsteVerificadoElEquipoPokemonVerde(Pokemon verde);
        void cuandoEsteVerificadoElEquipoPokemonAmarillo(Pokemon amarillo);
    }

    public void atacarVerde(Solicitud solicitud, Callback callback) {
        if (solicitud.datosPokemonVerde.getValue().getDefensa() > solicitud.datosPokemonAmarillo.getValue().getAtaque()) {
        }else {
            if (solicitud.datosPokemonVerde.getValue().getDefensaEspecial() > solicitud.datosPokemonAmarillo.getValue().getAtaqueEspecial()) {
                solicitud.datosPokemonVerde.getValue().setHp(solicitud.datosPokemonVerde.getValue().getHp() - solicitud.datosPokemonAmarillo.getValue().getAtaque());
            }else {
                solicitud.datosPokemonVerde.getValue().setHp(solicitud.datosPokemonVerde.getValue().getHp() - (solicitud.datosPokemonAmarillo.getValue().getAtaque() * 2));
            }
        }
        callback.cuandoEsteVerificadoElEquipoPokemonVerde(solicitud.datosPokemonVerde.getValue());
    }

    public void atacarAmarillo(Solicitud solicitud, Callback callback) {
        if (solicitud.datosPokemonAmarillo.getValue().getDefensa() > solicitud.datosPokemonVerde.getValue().getAtaque()) {
        }else {
            if (solicitud.datosPokemonAmarillo.getValue().getDefensaEspecial() > solicitud.datosPokemonVerde.getValue().getAtaqueEspecial()) {
                solicitud.datosPokemonAmarillo.getValue().setHp(solicitud.datosPokemonAmarillo.getValue().getHp() - solicitud.datosPokemonVerde.getValue().getAtaque());
            }else {
                solicitud.datosPokemonAmarillo.getValue().setHp(solicitud.datosPokemonAmarillo.getValue().getHp() - (solicitud.datosPokemonVerde.getValue().getAtaque() * 2));
            }
        }
        callback.cuandoEsteVerificadoElEquipoPokemonAmarillo(solicitud.datosPokemonAmarillo.getValue());
    }
}
