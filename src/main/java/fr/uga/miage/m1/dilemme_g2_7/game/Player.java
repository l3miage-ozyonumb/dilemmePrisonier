package fr.uga.miage.m1.dilemme_g2_7.game;

import java.util.ArrayList;
import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.client_server.Client;
import fr.uga.miage.m1.dilemme_g2_7.strategies.Strategy;

public class Player {
	private Client client;
	private Game game;
	private boolean isInteractive;
	private int currentScore;
	private Strategy strategy;
	private List<Choice> pastChoices;

	public Player(Game game){
		this.client = null;
		this.game = game;
		this.isInteractive = false;
		this.currentScore = 0;
		//this.strategy = ??
		//TODO: Get it to choose a random strategy
		this.pastChoices = new ArrayList<>();
	}
	
	public Choice makeChoice() {
		Choice c = isInteractive? client.makeChoice() : strategy.makeChoice(pastChoices, game.getChoicesOtherPlayer(this), game.getTourActuel());
		pastChoices.add(c);
		return c;
	}
	
	public void receivePoints(int points) {
		this.currentScore += points;
	}
	
	public void joinGame(Client c) {
		this.client = c;
		this.isInteractive = true;
	}
	
	public void abandonGame() {
		this.client = null;
		this.isInteractive = false;
		this.strategy = client.chooseStrategy();
	}

	//GETTERS AND SETTERS
	
	public int getScore() {
		return this.currentScore;
	}
	
	public boolean getIsInteractive() {
		return this.isInteractive;
	}

	public List<Choice> getPastChoices(){
		return this.pastChoices;
	}
}
