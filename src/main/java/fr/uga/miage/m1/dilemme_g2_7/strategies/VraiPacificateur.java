package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class VraiPacificateur extends Strategy{

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        Choice c;
		
		if(tour>1) {
			if(pastActionsOtherPlayer.get(tour-1).equals(Choice.COOPERER)&&pastActionsOtherPlayer.get(tour-2).equals(Choice.COOPERER)){
                c = Choice.COOPERER;
            }
            else{
                c = Choice.TRAHIR;
                if(rand.nextInt(1000)<50) {
                    c = Choice.COOPERER;
                }
            }
		}
		else c = fiftyOrFifty();
		
		return c;
    }

}
