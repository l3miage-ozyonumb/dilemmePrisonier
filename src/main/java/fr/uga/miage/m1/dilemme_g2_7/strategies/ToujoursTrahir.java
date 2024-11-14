package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class ToujoursTrahir extends Strategy{

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        return Choice.TRAHIR;
    }

}