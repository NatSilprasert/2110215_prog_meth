package card.type;

import card.base.UnitCard;
import player.Player;

//You CAN modify the first line
public class LeaderUnitCard extends UnitCard {
    private int buffPower;
    private int buffHealth;
	
	public LeaderUnitCard(String name, String flavorText, int bloodCost, int power, int health, int buffPower, int buffHealth) {
        super(name, flavorText, bloodCost, power, health);
        setBuffPower(buffPower);
        setBuffHealth(buffHealth);
	}

    public int attackUnit(UnitCard u) {
        int maxHealth = u.getHealth();
        int opponentHealth = Math.max(u.getHealth() - this.getPower(), 0);
        u.setHealth(opponentHealth);
        return Math.min(this.getPower(), maxHealth);
    }

    public void buffUnit(UnitCard[] alliesCard) {
        if (alliesCard != null) {
            for (UnitCard card : alliesCard) {
                card.setHealth(card.getHealth() + this.buffHealth);
                card.setPower(card.getPower() + this.buffPower);
            }
        }
    }

    public int getBuffPower() {
        return buffPower;
    }

    public void setBuffPower(int buffPower) {
        this.buffPower = Math.max(buffPower, 0);
    }

    public int getBuffHealth() {
        return buffHealth;
    }

    public void setBuffHealth(int buffHealth) {
        this.buffHealth = Math.max(buffHealth, 0);
    }
	
	@Override
	public String toString() {
		return super.getName() + " (POW: " + super.getPower() + ", HP: " + super.getHealth() + 
				" | POW Inc: "+ this.getBuffPower() + ", HP Inc: " + this.getBuffHealth() + ")";
	}

}