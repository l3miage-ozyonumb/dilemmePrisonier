package fr.uga.miage.m1.dilemme_g2_7.controllers;


import fr.uga.miage.m1.dilemme_g2_7.services.GameClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final GameClientService gameClientService;

    public ClientController(GameClientService gameClientService) {
        this.gameClientService = gameClientService;
    }

    @GetMapping("/status")
    public String getStatus() {
        return this.gameClientService.getServerStatus();
    }
}
