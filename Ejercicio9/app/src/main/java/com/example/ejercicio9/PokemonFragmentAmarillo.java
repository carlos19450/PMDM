package com.example.ejercicio9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.ejercicio9.databinding.FragmentPokemonAmarilloBinding;

public class PokemonFragmentAmarillo extends Fragment {
    Button botonAmarillo;
    NavController navController;
    private FragmentPokemonAmarilloBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentPokemonAmarilloBinding.inflate(inflater, container, false)).getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PokemonViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        botonAmarillo = view.findViewById(R.id.introducirDatosEquipoAmarilloBoton);
        navController = Navigation.findNavController(view);
        binding.introducirDatosEquipoAmarilloBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = binding.nombre.getText().toString();
                int hp = Integer.parseInt(binding.hp.getText().toString());
                int ataque = Integer.parseInt(binding.ataque.getText().toString());
                int defensa = Integer.parseInt(binding.defensa.getText().toString());
                int ataqueEspecial = Integer.parseInt(binding.ataqueEspecial.getText().toString());
                int defensaEspecial = Integer.parseInt(binding.defensaEspecial.getText().toString());

                elementosViewModel.verificarAmarillo(nombre, hp, ataque, defensa, ataqueEspecial, defensaEspecial);
                navController.navigate(R.id.action_pokemonFragmentAmarillo_to_pokemonFragmentVerde);
            }
        });
    }

}