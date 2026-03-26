package com.alura.conversor.modelos;

/**
 * Un Record es una clase que sirve para transportar datos.
 * Java genera automáticamente los métodos getter (como conversion_rate()),
 * el constructor y el metodo toString().
 */

public record Moneda(
        String base_code,      // Código de la moneda origen
        String target_code,    // Código de la moneda destino
        double conversion_rate // El valor de la tasa de cambio que devuelve la API
) {
}