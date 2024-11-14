package fr.uga.miage.m1.dilemme_g2_7.client_server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Game;
import fr.uga.miage.m1.dilemme_g2_7.services.GameClientService;
import fr.uga.miage.m1.dilemme_g2_7.strategies.Strategy;
import fr.uga.miage.m1.dilemme_g2_7.strategies.StrategyFactory;

public class Server {
	private String serverID;
	private List<Client> clientList;
	private List<Game> gameList;
	private StrategyFactory strategyFactory;
	private GameClientService gameClientService;
	private HashMap<Client, Game> clientsGames;
	
	public Server(String id, GameClientService gameClientService){
		this.serverID = id;
		this.clientList = new ArrayList<>();
		this.gameList = new ArrayList<>();
		this.strategyFactory = new StrategyFactory();
		this.gameClientService = gameClientService;
	}
	
	public void addClientToServer(Client c) {
		clientList.add(c);
	}
	
	public void createGameAndAddClient(int tours, Client c) {
		Game g = new Game(tours, c);
		gameList.add(g);
	}
	
	public void addClientToRandomGame(Client c) {
		boolean hasGame = false;
		int i=0;
		while(i<gameList.size()&&!hasGame){
			if(!gameList.get(i).getInteractivePlayers()) gameList.get(i).addClientAsPlayer(c);
			i++;
		}
		if(!hasGame){
			//TODO: return couldn't join any game error
		}
	}

	public void addClientToChosenGame(int index, Client c){
		gameList.get(index).addClientAsPlayer(c);
	}
	
	public void removeGame(Game g) {
		gameList.remove(g);
	}
	
	public Strategy giveStrategy(String nameStrategy) {
		return strategyFactory.giveStrategy(nameStrategy);
	}
}
