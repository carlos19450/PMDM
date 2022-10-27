package com.example.ejercicio4pmdm;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Calculator para calcular operaciones.
 */
public class Calculator {
    /**
     * Constructor de la clase Calculator para inicializarlo en MainActivity.
     */
    public Calculator() {
    }

    /**
     * Metodo para caclulas las sumas y multiplicaciones.
     * @param cadena String donde estan los numeros a calulcar.
     * @return devuelve el calculo.
     */
    public String calcula(String cadena) {
        int totalMult = 1, total = 0;
        List totalMultCopia = new ArrayList();
        String[] seprador = cadena.split("[+]");

        for (String cad: seprador) {
            cadena = cad;
            String[] acum = cadena.split("[*]");
            for (String cad2: acum) {
                try {
                    totalMult *= Integer.parseInt(cad2);
                }catch (NumberFormatException e) {
                    return "-1";
                }
            }
            totalMultCopia.add(totalMult);
            totalMult = 1;
        }
        for (Object num: totalMultCopia) {
            total += Integer.parseInt(String.valueOf(num));
        }
        cadena = String.valueOf(total);
        return cadena;
    }

    /**
     * Metodo que calcula el resultado final.
     * @param cadena String que se pasa por parametro para concatenarlo con button_Text.
     * @param button_Text String que se pasa por parametro para concatenarlo con cadena.
     * @return Devuelve la concatenación de button_Text y cadena.
     */
    public String calculaResultado(String cadena, String button_Text) {
        return button_Text + cadena;
    }
}
