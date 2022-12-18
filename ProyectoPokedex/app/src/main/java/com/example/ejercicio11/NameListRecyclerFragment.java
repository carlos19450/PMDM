package com.example.ejercicio11;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ejercicio11.databinding.FragmentNameListRecyclerBinding;
import com.example.ejercicio11.databinding.ViewholderNameListBinding;
import com.example.ejercicio11.models.NameListItem;

import java.util.List;

public class NameListRecyclerFragment extends Fragment {
    private FragmentNameListRecyclerBinding binding;
    private NamesViewModel namesViewModel;
    private NavController navController;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentNameListRecyclerBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        namesViewModel = new ViewModelProvider(requireActivity()).get(NamesViewModel.class);
        navController = Navigation.findNavController(view);
        MovesAdapter movesAdapter = new MovesAdapter();
        binding.recyclerView.setAdapter(movesAdapter);

        // Cuando cambia el viewmodel se actualiza la lista con setList(List<MoveListItem> moveList)
        namesViewModel.getAll().observe(getViewLifecycleOwner(), movesAdapter::setList);
    }

    class MovesAdapter extends RecyclerView.Adapter<MoveViewHolder> {
        List<NameListItem> moveList;

        @NonNull
        @Override
        public MoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MoveViewHolder(ViewholderNameListBinding.inflate(getLayoutInflater(), parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MoveViewHolder holder, int position) {
            NameListItem element = moveList.get(position);
            holder.binding.setName(element);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    namesViewModel.select(element);
                    navController.navigate(R.id.action_moveListRecyclerFragment_to_nameDetailFragment);
                }
            });
        }

        @Override
        public int getItemCount() {
            return moveList != null ? moveList.size() : 0;
        }

        public void setList(List<NameListItem> moveList){
            this.moveList = moveList;
            notifyDataSetChanged();
        }
    }

    static class MoveViewHolder extends RecyclerView.ViewHolder {
        private final ViewholderNameListBinding binding;

        public MoveViewHolder(ViewholderNameListBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}