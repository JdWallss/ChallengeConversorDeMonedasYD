package com.AluraChallenges.ConversorDeMonedas.Models;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConseguirCambio {

    public Moneda buscarMoneda(String tipoDeMoneda) {

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5f4e0c295192ab5042ef7b34/latest/" + tipoDeMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esa moneda.", e);
        }
    }

    // Método para realizar la conversión de moneda
    public static double convertirMoneda(double tasaOrigen, double tasaDestino, double cantidad) {
        return cantidad * (tasaDestino / tasaOrigen);
    }
}