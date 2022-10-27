package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button , button2;
    TextView current1, total1, current2, total2, ganador1, ganador2;
    String final1, final2;
    int acumPuntosTotal1 = 0, acumPuntosTotal2 = 0, acumCurrent1 = 0, acumCurrent2 = 0, jugador = 0, opc1, opc2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        current1 = (TextView) findViewById(R.id.textViewPuntuacion1);
        total1 = (TextView) findViewById(R.id.textViewTotal1);
        current2 = (TextView) findViewById(R.id.textViewPuntuacion2);
        total2 = (TextView) findViewById(R.id.textViewTotal2);
        button = (Button) findViewById(R.id.buttonRoll);
        button2 = (Button) findViewById(R.id.buttonHold);
        ganador1 = (TextView) findViewById(R.id.textViewGanador1);
        ganador2 = (TextView) findViewById(R.id.textViewGanador2);
        button.setOnClickListener(view -> {
            if (opc1 >= 100) {
                ganador1.setText("GANADOR!!!");
            }else if (opc2 >= 100) {
                ganador2.setText("GANADOR!!!");
            }else {
                if (jugador == 0) {
                    int numRandom = (int) (Math.random() * 6);
                    String numCadena1 = String.valueOf(numRandom);

                    if (numCadena1.equals("1")) {
                        current1.setText("0");
                        acumCurrent1 = 0;
                        jugador = 1;
                    } else {
                        acumCurrent1 += numRandom;
                        numCadena1 = String.valueOf(acumCurrent1);
                        current1.setText(numCadena1);
                    }
                } else {
                    int numRandom = (int) (Math.random() * 6);
                    String numCadena2 = String.valueOf(numRandom);

                    if (numCadena2.equals("1")) {
                        current2.setText("0");
                        acumCurrent2 = 0;
                        jugador = 0;
                    } else {
                        acumCurrent2 += numRandom;
                        numCadena2 = String.valueOf(acumCurrent2);
                        current2.setText(numCadena2);
                    }
                }
            }
        });
        button2.setOnClickListener(view -> {
            if (jugador == 0) {
                int num;
                String punt1 = current1.getText().toString();

                num = Integer.valueOf(punt1);
                acumPuntosTotal1 += num;
                total1.setText(String.valueOf(acumPuntosTotal1));
                jugador = 1;
                current1.setText("0");
                acumCurrent1 = 0;
                final1 = total1.getText().toString();
                opc1 = Integer.valueOf(final1);
            } else {
                int num;
                String punt2 = current2.getText().toString();
                num = Integer.valueOf(punt2);
                acumPuntosTotal2 += num;
                total2.setText(String.valueOf(acumPuntosTotal2));
                jugador = 0;
                current2.setText("0");
                acumCurrent2 = 0;
                final2 = total2.getText().toString();
                opc2 = Integer.valueOf(final2);
            }
        });

    }
}