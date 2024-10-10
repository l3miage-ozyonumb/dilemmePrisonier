package Strategy;

import java.util.List;
import java.util.Random;

public abstract class Strategy {	
	public abstract Choix faireChoix(List<Choix> listActionsAutreJoueur, int tour);
	
	protected Choix fiftyOrFifty() {
		Random rand = new Random();
		Choix c;
		int rand_int = rand.nextInt(100);
		if(rand_int>50) c = Choix.COOPERER;
		else c = Choix.TRAHIR;
		return c;
	}
}
