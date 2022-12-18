package com.example.ejercicio11;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ejercicio11.models.Pokemon;
import com.example.ejercicio11.models.NameListItem;
import com.example.ejercicio11.poqueapi.PokeAPI;

import java.util.List;

public class NamesViewModel extends AndroidViewModel {
    MutableLiveData<Pokemon> selectedNameMutableLiveData = new MutableLiveData<>();
    MutableLiveData<List<NameListItem>> listElementosMutableLiveData = new MutableLiveData<>();
    NameListItem selected;

    public NamesViewModel(@NonNull Application application) {
        super(application);
        PokeAPI.getNameList(listElementosMutableLiveData);
    }

    MutableLiveData<List<NameListItem>> getAll(){
        return listElementosMutableLiveData;
    }

    public void select(NameListItem nameListItem) {
        selected = nameListItem;
    }

    public MutableLiveData<Pokemon> getSelected() {
        PokeAPI.getName(selected.getName(), selectedNameMutableLiveData);
        return selectedNameMutableLiveData;
    }
}
