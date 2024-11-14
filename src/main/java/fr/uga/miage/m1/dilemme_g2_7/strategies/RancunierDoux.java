package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class RancunierDoux extends Strategy{
    int contTrahir = 4;
    int contCooperer = 2;
    boolean punir = false;

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        Choice c;

        if(pastActionsOtherPlayer.get(tour-1).equals(Choice.TRAHIR)){ 
            punir = true;
        }

        if(contCooperer == 0){
            contTrahir = 4;
            contCooperer = 2;
            punir = false;
        }

        if(punir){
            if(contTrahir>0){
                contTrahir--;
                c = Choice.TRAHIR;
            }
            else{
                contCooperer--;
                c = Choice.COOPERER;
            }
        }
        else{
            c = Choice.COOPERER;
        }

        return c;
    }

}
