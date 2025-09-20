package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class VenomUnitCard extends UnitCard {
	
	public VenomUnitCard(String name, String flavorText, int bloodCost, int power, int health) {
        super(name, flavorText, bloodCost, power, health);
	}

    public int attackUnit(UnitCard u) {
        int maxHealth = u.getHealth();
        u.setHealth(0);
        return maxHealth;
    }

    public int dead(Player player) {
        player.takeDamage(this.getPower());
        return this.getPower();
    }
	
}
