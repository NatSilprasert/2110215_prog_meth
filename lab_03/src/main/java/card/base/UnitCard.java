package card.base;

import player.Player;

//You CAN modify the first line
public abstract class UnitCard extends Card  {
    int power;
    int health;

	public UnitCard(String name, String flavorText, int bloodCost, int power, int health) {
        super(name, flavorText, bloodCost);
        setPower(power);
        setHealth(health);
	}

    public abstract int attackUnit(UnitCard u);

    public void setPower(int power) {
        this.power = Math.max(power, 0);
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int attackPlayer(Player opponent) {
        opponent.takeDamage(power);
        return power;
	}

    public int getPower() {
        return power;
    }

    public int getHealth() {
        return health;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.getName() + "\tCost: " + this.getBloodCost() +"\t(POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

}
