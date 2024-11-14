package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class PacificateurNaif extends Strategy{

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        Choice c;
		
		if(tour>0) {
			c = pastActionsOtherPlayer.get(tour-1);
			if(rand.nextInt(1000)<50 && c.equals(Choice.TRAHIR)) {
				c = Choice.COOPERER;
			}
		}
		else c = fiftyOrFifty();
		
		return c;
    }

}
