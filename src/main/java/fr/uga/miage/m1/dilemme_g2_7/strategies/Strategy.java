package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;
import java.util.Random;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public abstract class Strategy {
	protected Random rand = new Random();

	public abstract Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour);
	protected Choice fiftyOrFifty() {
		return rand.nextInt(100)>50? Choice.COOPERER : Choice.TRAHIR;
	}
}
