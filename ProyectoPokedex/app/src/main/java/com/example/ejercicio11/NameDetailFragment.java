package com.example.ejercicio11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.ejercicio11.databinding.FragmentNameDetailBinding;
import com.example.ejercicio11.models.Pokemon;

public class NameDetailFragment extends Fragment {

    private FragmentNameDetailBinding binding;
    NamesViewModel namesViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        namesViewModel = new ViewModelProvider(requireActivity()).get(NamesViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        namesViewModel.getSelected().observe(getViewLifecycleOwner(), new Observer<Pokemon>() {
            @Override
            public void onChanged(Pokemon m) {
                binding.setNamePokemon(m);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return (binding = FragmentNameDetailBinding.inflate(inflater, container, false)).getRoot();

    }
}