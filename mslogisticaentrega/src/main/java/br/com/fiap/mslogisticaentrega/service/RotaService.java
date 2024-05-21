package br.com.fiap.mslogisticaentrega.service;

import org.springframework.stereotype.Service;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RotaService {
    private static final String ORS_API_KEY = "your-api-key"; // replace with your OpenRouteService API key

    public ResponseEntity<String> calcularRota(String origem, String destino) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", ORS_API_KEY);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("https://api.openrouteservice.org/v2/directions/driving-car")
                .queryParam("start", origem)
                .queryParam("end", destino);

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Response: " + response.getBody());
            return response;
        } else {
            System.out.println("Error: " + response.getStatusCode());
        }
        return response;
    }
}