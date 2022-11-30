package com.example.ejercicio9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ejercicio9.databinding.FragmentPokemonAmarilloBinding;
import com.example.ejercicio9.databinding.FragmentPokemonVerdeBinding;

public class PokemonFragmentVerde extends Fragment {
    private FragmentPokemonVerdeBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPokemonVerdeBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PokemonViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        binding.introducirDatosEquipoVerdeBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.nombre.getText().toString();
                int hp = Integer.parseInt(binding.hp.getText().toString());
                int ataque = Integer.parseInt(binding.ataque.getText().toString());
                int defensa = Integer.parseInt(binding.defensa.getText().toString());
                int ataqueEspecial = Integer.parseInt(binding.ataqueEspecial.getText().toString());
                int defensaEspecial = Integer.parseInt(binding.defensaEspecial.getText().toString());
            }
        });
    }
}