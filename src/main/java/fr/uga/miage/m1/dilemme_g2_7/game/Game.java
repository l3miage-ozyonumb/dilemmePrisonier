package fr.uga.miage.m1.dilemme_g2_7.game;

import java.util.List;
import fr.uga.miage.m1.dilemme_g2_7.client_server.Client;

public class Game {
	private int tours;
	private int tourActuel;
	private Player player1;
	private Player player2;
	private static final int T = 5;
	private static final int D = 0;
	private static final int C = 3;
	private static final int P = 1;

	public Game(int tours, Client client){
		//we initialize the players
		player1 = new Player(this);
		player2 = new Player(this);
		//we add our client as the original player
		addClientAsPlayer(client);
		//we set the turns
		this.tours = tours;
		this.tourActuel = 0;
	}

	//LIFE CYCLE OF THE GAME

	//perhaps this should be added within the constructor?
	//to choose that, it depends on whether the game immediately starts with
	//one player, or if it waits until there are 2
	//does the game restart when a client joins in the AI's place? Or does it continue?
	public void playGame(){
		while(tourActuel<tours){
			playTour();
			tourActuel++;
		}
		endGame();
	}
	
	public void playTour() {
		//we calculate the points to give to each player based on their choices
		calculateAndGivePoints(player1.makeChoice(), player2.makeChoice());
	}

	private void endGame() {
		//we disconnect any possibly connected players
		player1.abandonGame();
		player2.abandonGame();
	}

	//ACTIONS OF THE GAME
	
	public void addClientAsPlayer(Client c) {
		if(!getInteractivePlayers()){
			if(player1.getIsInteractive()){
				player2.joinGame(c);
			}
		}
		else{
			//TODO: ERROR in which both players are already interactive
			//client can't join the game
		}
	}
	
	private void calculateAndGivePoints(Choice player1Choice, Choice player2Choice) {
		if(player1Choice.equals(player2Choice)){
			if(player1Choice.equals(Choice.TRAHIR)){
				player1.receivePoints(P);
				player2.receivePoints(P);
			}
			else{
				player1.receivePoints(C);
				player2.receivePoints(C);
			}
		}
		else{
			if(player1Choice.equals(Choice.TRAHIR)){
				player1.receivePoints(T);
				player2.receivePoints(D);
			}
			else{
				player1.receivePoints(D);
				player2.receivePoints(T);
			}
		}
	}
	
	//GETTERS AND SETTERS
	
	public boolean getInteractivePlayers() {
		return player1.getIsInteractive()&&player2.getIsInteractive();
	}
	
	public List<Choice> getChoicesOtherPlayer(Player p) {
		return player1.equals(p)? player2.getPastChoices() : player1.getPastChoices();
	}
	
	public Player getGameResults(){
		if(player1.getScore()>player2.getScore()){
			return player1;
		}
		else{
			return player2;
		}
		//TODO: HOW DO WE HANDLE A TIE?
	}
	
	public int getTourActuel() {
		return this.tourActuel;
	}
}
