package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class SondeurRepentant extends Strategy{
    boolean testDone = false;

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        Choice c;
		
		if(tour>0) {
            //in this case, does the choice to cooperate last forever, or does it change
            //by the next turn?
			c = testDone? Choice.COOPERER : pastActionsOtherPlayer.get(tour-1);
			if(rand.nextInt(1000)<50) {
				if(c==Choice.TRAHIR) c = Choice.COOPERER;
				else c = Choice.TRAHIR;
                testDone = true;
			}
		}
		else c = fiftyOrFifty();
		
		return c;
    }

}
