package fr.uga.miage.m1.dilemme_g2_7.services;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GameClientService {

    private final RestTemplate restTemplate;

    public GameClientService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public String getServerStatus() {
        return this.restTemplate.getForObject("http://localhost:8080/game/status", String.class);
    }
}
