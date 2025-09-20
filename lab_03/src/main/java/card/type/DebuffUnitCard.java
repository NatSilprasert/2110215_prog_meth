package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class DebuffUnitCard extends UnitCard {
    private int debuffPower;
	
	public DebuffUnitCard(String name, String flavorText, int bloodCost, int power, int health, int debuffPower) {
        super(name, flavorText, bloodCost, power, health);
        setDebuffPower(debuffPower);
	}

    public int attackUnit(UnitCard u) {
        int maxHealth = u.getHealth();
        int opponentHealth = Math.max(u.getHealth() - this.getPower(), 0);
        int opponentPower = Math.max(u.getPower() - this.getDebuffPower(), 0);
        u.setHealth(opponentHealth);
        u.setPower(opponentPower);
        return Math.min(this.getPower(), maxHealth);
    }

    public int getDebuffPower() {
        return debuffPower;
    }

    public void setDebuffPower(int debuffPower) {
        this.debuffPower = Math.max(debuffPower, 0);
    }
}
