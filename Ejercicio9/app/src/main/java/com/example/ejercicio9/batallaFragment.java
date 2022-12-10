package com.example.ejercicio9;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ejercicio9.databinding.FragmentBatallaBinding;
import com.example.ejercicio9.databinding.FragmentPokemonAmarilloBinding;

public class batallaFragment extends Fragment {
    private FragmentBatallaBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentBatallaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PokemonViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        binding.hpValueVerde.setText(String.valueOf(elementosViewModel.verde.getHp()));
        binding.hpValueAmarillo.setText(String.valueOf(elementosViewModel.amarillo.getHp()));
        binding.textoAmarillo.setText("");
        binding.textoVerde.setText("");
        binding.atacarVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textoAmarillo.setText("");
                binding.textoVerde.setText("");
                elementosViewModel.atacarVerde();
            }
        });

        elementosViewModel.datosPokemonVerde.observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                if (Integer.parseInt((String) binding.hpValueVerde.getText()) > 0) {
                    if (binding.hpValueVerde.getText().equals(String.valueOf(pokemon.getHp()))) {
                        binding.textoVerde.setText("Ataque fallido");
                    }else {
                        binding.hpValueVerde.setText(String.valueOf(pokemon.getHp()));
                        binding.textoVerde.setText("Ataque acertado");
                    }
                    if (Integer.parseInt((String) binding.hpValueVerde.getText()) < 100) {
                        binding.hpVerde.setText("HP: ¡Poca Vida!");
                    }
                }else {
                    binding.textoVerde.setText("¡Pokemon del equipo verde abatido!");
                    binding.textoAmarillo.setText("¡Equipo amarillo GANADOR!");
                    binding.atacarAmarillo.setEnabled(false);
                    binding.atacarVerde.setEnabled(false);
                }
            }
        });

        binding.atacarAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.textoAmarillo.setText("");
                binding.textoVerde.setText("");
                elementosViewModel.atacarAmarillo();
            }
        });

        elementosViewModel.datosPokemonAmarillo.observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon pokemon) {
                if (Integer.parseInt((String) binding.hpValueAmarillo.getText()) > 0) {
                    if (binding.hpValueAmarillo.getText().equals(String.valueOf(pokemon.getHp()))) {
                        binding.textoAmarillo.setText("Ataque fallido");
                    }else {
                        binding.hpValueAmarillo.setText(String.valueOf(pokemon.getHp()));
                        binding.textoAmarillo.setText("Ataque acertado");
                    }
                    if (Integer.parseInt((String) binding.hpValueAmarillo.getText()) < 100) {
                        binding.hpAmarillo.setText("HP: ¡Poca Vida!");
                    }
                }else {
                    binding.textoAmarillo.setText("¡Pokemon del equipo amarillo abatido!");
                    binding.textoVerde.setText("¡Equipo verde GANADOR!");
                    binding.atacarAmarillo.setEnabled(false);
                    binding.atacarVerde.setEnabled(false);
                }
            }
        });
    }
}