package com.alura.conversor.calculos;
// Import de clases de otros paquetes
import com.alura.conversor.modelos.Moneda;

public class GeneradorDeCalculos {

    public double convertir(double cantidad, Moneda moneda) {
        // Multiplicamos el monto por la tasa que viene de la API
        //La tasa se toma desde el record Moneda
        return cantidad * moneda.conversion_rate(); 
    }
}
