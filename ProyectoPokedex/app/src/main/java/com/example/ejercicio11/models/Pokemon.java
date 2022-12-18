package com.example.ejercicio11.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    private String name;
    private int height;

    // TODO falta serializar el listado de Pokémon, en el JSON de la API se llama learned_by_pokemon no pokemons.
    @SerializedName("learned_by_pokemon")
    private List<PokemonList> pokemons;

    public String getName() {
        return name;
    }

    public String getHeight() {
        return String.valueOf(height);
    }

    public List<PokemonList> getPokemons() {
        return pokemons;
    }
}
