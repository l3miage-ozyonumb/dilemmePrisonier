package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class Rancunier extends Strategy{
    boolean trahir = false;

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        if(tour>0 && pastActionsOtherPlayer.get(tour-1).equals(Choice.TRAHIR)){
            trahir = true; 
        }
        return trahir? Choice.TRAHIR : Choice.COOPERER;
    }

}
