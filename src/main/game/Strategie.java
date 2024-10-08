
public class Strategie{

    public String donnantDonnant(String dernierDecisionAdversaire ){
        return dernierDecisionAdversaire;
    }

    public String donnantPourDeuxDonnants(String dernierCoupAdversaire, String avantDernierCoupAdversaire) {
        if (dernierCoupAdversaire.equals(avantDernierCoupAdversaire)) {
            return dernierCoupAdversaire;
        }
    }
}