package com.example.ejercicio4pmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Calculator calcula = new Calculator();
    TextView resultado;
    MaterialButton button_0, button_1 , button_2, button_3, button_4 , button_5, button_6, button_7 , button_8, button_9, button_C, button_Igual, button_Mas, button_Mult;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultado = findViewById(R.id.textViewResultado);
        idAsignada(button_0, R.id.button0);
        idAsignada(button_1, R.id.button1);
        idAsignada(button_2, R.id.button2);
        idAsignada(button_3, R.id.button3);
        idAsignada(button_4, R.id.button4);
        idAsignada(button_5, R.id.button5);
        idAsignada(button_6, R.id.button6);
        idAsignada(button_7, R.id.button7);
        idAsignada(button_8, R.id.button8);
        idAsignada(button_9, R.id.button9);
        idAsignada(button_C, R.id.buttonC);
        idAsignada(button_Igual, R.id.buttonIgual);
        idAsignada(button_Mas, R.id.buttonMas);
        idAsignada(button_Mult, R.id.buttonMult);

    }
    void idAsignada(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String button_Text = button.getText().toString();
        String cadena = resultado.getText().toString();
        System.out.println(cadena);
        if (button_Text.equals("=")) {
            cadena = calcula.calcula(cadena);
        }else if (button_Text.equals("C")) {
            resultado.setText("");
            return;
        }else {
            cadena = calcula.calculaResultado(button_Text, cadena);
        }
        resultado.setText(cadena);
    }
}