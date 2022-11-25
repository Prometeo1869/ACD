package paquete;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Mainw {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://twitch-game-popularity.p.rapidapi.com/game?name=Elden%20Ring&year=2022&month=08"))
					.header("X-RapidAPI-Key", "0ac2e18068mshf7a010ee45c4819p12a192jsne00804b74b8f")
					.header("X-RapidAPI-Host", "twitch-game-popularity.p.rapidapi.com")
					.method("GET", HttpRequest.BodyPublishers.noBody())
					.build();
			HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());
		} catch (Exception e) {
			System.out.println("hola");
		}
	}

}
