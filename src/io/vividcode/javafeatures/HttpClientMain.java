package io.vividcode.javafeatures;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientMain {

  public void sendRequest() throws IOException, InterruptedException {
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpResponse<String> response = httpClient
        .send(HttpRequest.newBuilder().GET()
            .uri(URI.create("https://github.com")).build(), BodyHandlers.ofString());
    System.out.println(response.body());
  }

  public static void main(String[] args) throws IOException, InterruptedException {
    new HttpClientMain().sendRequest();
  }
}
