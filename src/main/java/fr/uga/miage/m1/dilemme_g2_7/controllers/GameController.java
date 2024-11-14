package fr.uga.miage.m1.dilemme_g2_7.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// This class is for handle the http requests related to the game

@RestController
@RequestMapping("/game")
public class GameController {

    @GetMapping("/status")
    public String getStatus() {
        return "Game is running";
    }

    @PostMapping("/start")
    public String startGame() {
        return "Game started";
    }
}
