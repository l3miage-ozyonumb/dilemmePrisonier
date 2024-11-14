package fr.uga.miage.m1.dilemme_g2_7.strategies;

import java.util.List;

import fr.uga.miage.m1.dilemme_g2_7.game.Choice;

public class Graduel extends Strategy{
    int foisTrahir = 0;
    int contCooperer = 0;
    int contTrahir = 0;
    boolean trahir = false;

    @Override
    public Choice makeChoice(List<Choice> pastActionsPlayer, List<Choice> pastActionsOtherPlayer, int tour) {
        //each time we are betrayed, we add to the total counter of betrays, we set the cooperate counter to 0 (it goes up to 2), and we set the flag to betray to true
        if(pastActionsOtherPlayer.get(tour-1).equals(Choice.TRAHIR)){
            foisTrahir++;
            contCooperer = 0;
            trahir = true;
        }

        //when we have been betrayed in the past and we have already cooperated 2 times after that, we betray again
        if(foisTrahir>1 && contCooperer>=2){
            trahir = true;
        }

        //if we've already betrayed as many times as many times as the other player betrayed us, we stop betraying and set the counter of betrays to do to zero
        if(contTrahir>foisTrahir){
            trahir = false;
            contTrahir = 0;
        }

        //if we have to betray, we do so and we add to the counter, otherwise, we do the same with cooperation
        if(trahir){
            contTrahir++;
            return Choice.TRAHIR;
        }
        else{
            contCooperer++;
            return Choice.COOPERER;
        }
    }

}
