package com.alura.conversor.calculos;
// Import de clases de otros paquetes
import com.alura.conversor.modelos.Moneda;
import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {

    public Moneda buscarMoneda(String monedaBase, String monedaDestino) {
        // Formamos la URL dinámica insertando los códigos de las monedas
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/7acc027ff55c55e0cfc51ab7/pair/" +
                monedaBase + "/" + monedaDestino);

        // El HttpClient es el que hará la petición
        HttpClient client = HttpClient.newHttpClient();

        // Construimos la solicitud (Request) indicando a qué dirección ir
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Enviamos la solicitud y recibimos la respuesta como una cadena de texto (String)
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Usamos GSON para convertir ese texto JSON automáticamente en un objeto de tipo Moneda
            // utilizamos una deserialización directa en vez de usar JsonParser o JsonObject
            // Gson mira el molde (Moneda) y llena todos los datos de un solo golpe.
            return new Gson().fromJson(response.body(), Moneda.class);

        } catch (Exception e) {
            // Si algo falla, lanzamos una excepción con el error
            throw new RuntimeException("No pude realizar la conversión: " + e.getMessage());
        }
    }
}