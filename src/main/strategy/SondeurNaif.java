package Strategy;

import java.util.List;
import java.util.Random;

public class SondeurNaif extends Strategy{

	@Override
	public Choix faireChoix(List<Choix> listActionsAutreJoueur, int tour) {
		Choix c;
		Random rand = new Random();
		
		if(tour>0) {
			int rand_int = rand.nextInt(1000);
			c = listActionsAutreJoueur.get(tour-1);
			if(rand_int<50) {
				if(c==Choix.TRAHIR) c = Choix.COOPERER;
				else c = Choix.TRAHIR;
			}
		}
		else c = fiftyOrFifty();
		
		return c;
	}

}
