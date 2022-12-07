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
    TextView hpVerde;
    TextView hpAmarillo;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentBatallaBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hpVerde = view.findViewById(R.id.hpVerde);
        hpAmarillo = view.findViewById(R.id.hpAmarillo);
        PokemonViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(PokemonViewModel.class);
        binding.atacarVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementosViewModel.datosPokemonAmarillo.observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
                    @Override
                    public void onChanged(Pokemon pokemon) {
                        binding.hpVerde.setText(String.format("%.2f",elementosViewModel.datosPokemonAmarillo));
                    }
                });
                hpVerde.setText(elementosViewModel.datosPokemonVerde.getValue().getHp());
            }
        });
        binding.atacarAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                elementosViewModel.datosPokemonAmarillo.observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
                    @Override
                    public void onChanged(Pokemon pokemon) {
                        binding.hpAmarillo.setText(String.format("%.2f",cuota));
                    }
                });
                hpAmarillo.setText(elementosViewModel.datosPokemonAmarillo.getValue().getHp());
            }
        });
    }
}