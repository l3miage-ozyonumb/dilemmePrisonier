package Strategy;

import java.util.ArrayList;
import java.util.List;

public class StrategyFactory {
	StrategyFactory strategyFactory = null;
	List<Strategy> strategyList = new ArrayList<>(3);
	
	public StrategyFactory() {
		strategyList.set(0, new DonnantDonnant());
		strategyList.set(1, new SondeurNaif());
		strategyList.set(2, new DonnantPourDeux());
	}
	
	Strategy s;
	public Strategy chooseStrategy(String nomStrategy) {
		switch (nomStrategy){
		case "Donnant Donnant":
			s = strategyList.get(0);
		case "Sondeur Naif":
			s = strategyList.get(1);
		case "Donnant Pour Deux Donnants":
			s = strategyList.get(2);
		default:
			s = strategyList.get(0);
		}
		return s;
	}
	
	public StrategyFactory getInstance() {
		if(strategyFactory == null) {
			this.strategyFactory = new StrategyFactory();
		}
		return strategyFactory;
	}
}
