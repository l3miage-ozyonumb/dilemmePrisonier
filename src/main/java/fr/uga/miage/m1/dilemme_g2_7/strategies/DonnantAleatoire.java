package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class DonnantAleatoire extends Strategy{

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        return (rand.nextInt(1000)<50 || tour<1)? fiftyOrFifty() : pastActionsOtherPlayer.get(tour-1);
    }

}
