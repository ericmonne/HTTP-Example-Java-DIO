package com.httpexamples;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.time.Duration;

public class PostRequest {

    public static final String URL_POST = "http://httpbin.org/forms/post";
    public static final String FILE_JSON = "C:\\Users\\ericm\\Documents\\Programação\\DIO-GFT-Primeiro-Repositório\\dio-desafio-github-primeiro-repositorio\\GFT - anotacoes\\POO.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        //cliente HTTP
        HttpClient client = HttpClient.newHttpClient();

        //criar a requisição
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(FILE_JSON)))
                .timeout(Duration.ofSeconds(10))
                .uri(URI.create(URL_POST))
                .build();


        //requisição assíncrona; não se exige a variável?
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
}
