package fr.uga.miage.m1.dilemme_g2_7.strategies;

public class StrategyFactory {
	private static StrategyFactory instance;
	
	public static StrategyFactory getInstance() {
		if(instance == null){
			instance = new StrategyFactory();
		}
		return instance;
	}
	
	public Strategy giveStrategy(String nameStrategy) {
		Strategy s = new DonnantDonnant();
		switch (nameStrategy) {
			case "Donnant donnant":
				break;	
			case "Donnant donnant aléatoire":
				s = new DonnantAleatoire();
				break;
			case "Donnant pour deux donnants":
				s = new DonnantPourDeux();
				break;
			case "Sondeur naif":
				s = new SondeurNaif();
				break;
			case "Sondeur repentant":
				s = new SondeurRepentant();
				break;
			case "Pacificateur naif":
				s = new PacificateurNaif();
				break;
			case "Vrai pacificateur":
				s = new VraiPacificateur();
				break;
			case "Aleatoire":
				s = new Aleatoire();
				break;
			case "Toujours Trahir":
				s = new ToujoursTrahir();
				break;
			case "Toujours Cooperer":
				s = new ToujoursCooperer();
				break;
			case "Rancunier":
				s = new Rancunier();
				break;
			case "Pavlov":
				s = new Pavlov();
				break;
			case "Pavlov Aleatoire":
				s = new PavlovAleatoire();
				break;
			case "Adaptatif":
				s = new Adaptatif();
				break;
			case "Graduel":
				s = new Graduel();
				break;
			case "Donnant donnant soupçonneux":
				s = new DonnantDonnantSoup();
				break;
			case "Rancunier doux":
				s = new RancunierDoux();
				break;
			default:
				break;
		}
		return s;
	}
	
}
