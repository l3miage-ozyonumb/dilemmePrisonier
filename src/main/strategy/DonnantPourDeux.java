package Strategy;

import java.util.List;
import java.util.Random;

public class DonnantPourDeux extends Strategy{
	@Override
	public Choix faireChoix(List<Choix> listActionsAutreJoueur, int tour) {
		Choix c;
		
		if(tour>1 ) {
			boolean reciprocate = listActionsAutreJoueur.get(tour-1) == listActionsAutreJoueur.get(tour-2);
			if(reciprocate) c =  listActionsAutreJoueur.get(tour-1);
			else c = fiftyOrFifty();
		}
		else c = fiftyOrFifty();
		
		return c;
	}

}
