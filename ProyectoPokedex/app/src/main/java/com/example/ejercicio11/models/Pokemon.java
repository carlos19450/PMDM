package com.example.ejercicio11.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Pokemon {
    private int numero;
    private String name;
    private String url;

    // TODO falta serializar el listado de Pokémon, en el JSON de la API se llama learned_by_pokemon no pokemons.
    @SerializedName("learned_by_pokemon")
    private List<PokemonList> pokemons;

    public int getNumero() {
        String[] urlPartes = url.split("/");
        return Integer.parseInt(urlPartes[urlPartes.length - 1]);
    }

    public String getName() {
        return name;
    }

    public List<PokemonList> getPokemons() {
        return pokemons;
    }

    public String getPokemonsString() {
        String s = "";
        for (int i = 0; pokemons != null && i<pokemons.size(); i++) {
            s += pokemons.get(i).getName() + " ";
        }
        return  s;
    }
}
