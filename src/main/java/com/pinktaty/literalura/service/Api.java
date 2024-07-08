package com.pinktaty.literalura.service;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Si postgres da dificultades, ejecutar el servicio manualmente:
// W + R: services.msc, servicio: postgresql-x64-xx

@Component
public class Api {
    private final String URL_BASE = "https://gutendex.com/";

    public String obtainData(String petition) {
        String url = URL_BASE + petition;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
    }
}
