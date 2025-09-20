package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class NormalUnitCard extends UnitCard {
	
	public NormalUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
		super(name, flavorText, bloodCost, power, health);
	}

    public int attackUnit(UnitCard u) {
        int maxHealth = u.getHealth();
        int opponentHealth = Math.max(u.getHealth() - this.getPower(), 0);
        u.setHealth(opponentHealth);
        return Math.min(this.getPower(), maxHealth);
    }
}

