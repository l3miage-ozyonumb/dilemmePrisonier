package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class Pavlov extends Strategy{

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        if(tour>0){
            Choice alternative = (pastActionsPlayer.get(tour-1).equals(Choice.COOPERER))? Choice.TRAHIR : Choice.COOPERER;
            return (pastActionsOtherPlayer.get(tour-1).equals(Choice.COOPERER))? pastActionsPlayer.get(tour-1) : alternative;
        }
        else{
            return fiftyOrFifty();
        }
    }

}
