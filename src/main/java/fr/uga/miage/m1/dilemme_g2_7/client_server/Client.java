package fr.uga.miage.m1.dilemme_g2_7.client_server;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;
import fr.uga.miage.m1.dilemme_g2_7.strategies.Strategy;


public class Client {
	private String id;
	private Server server;
	
	public Client(String id){
		this.id = id;
	}
	
	public void joinServer() {
		
	}
	
	public void createAndJoinGame() {
		server.createGameAndAddClient(0, this); //TODO: take data about tours
	}
	
	public void joinRandomGame() {
		server.addClientToRandomGame(this);
	}

	public void chooseAndJoinGame(){
		//TODO: take data about choice of game
		//server.getGameList();
		//int index = chooseGame();
		//server.addClientToChosenGame(index, this);
	}
	
	public Choice makeChoice() {
		//TODO
		return null;
	}
	
	public void abandonGame() {
		//TODO
	}
	
	public Strategy chooseStrategy() {
		//TODO
		//server.giveStrategy("texto");
		return null;
	}
}
