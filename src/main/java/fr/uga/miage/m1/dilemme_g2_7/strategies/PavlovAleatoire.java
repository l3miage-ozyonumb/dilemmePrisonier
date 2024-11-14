package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class PavlovAleatoire extends Strategy{

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        if(rand.nextInt(1000)<50 || tour<1){
            return fiftyOrFifty();
        }
        else{
            Choice alternative = (pastActionsPlayer.get(tour-1).equals(Choice.COOPERER))? Choice.TRAHIR : Choice.COOPERER;
            return (pastActionsOtherPlayer.get(tour-1).equals(Choice.COOPERER))? pastActionsPlayer.get(tour-1) : alternative;
        }
    }

}
