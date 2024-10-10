package Strategy;

import java.util.List;
import java.util.Random;

public class DonnantDonnant extends Strategy{

	@Override
	public Choix faireChoix(List<Choix> listActionsAutreJoueur, int tour) {
		Choix c;
		//if there is a previous turn we follow the actions
		//of the other player. Otherwise random.
		if(tour>0) {
			c = listActionsAutreJoueur.get(tour-1);
		}
		else c = fiftyOrFifty();
		return c;
	}

}
