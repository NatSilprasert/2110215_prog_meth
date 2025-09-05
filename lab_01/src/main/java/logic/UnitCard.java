package logic;

import java.util.Objects;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

    public UnitCard(String name, int bloodCost, int power, int health, String flavorText) {
        setName(name);
        setBloodCost(bloodCost);
        setPower(power);
        setHealth(health);
        setFlavorText(flavorText);
    }

    public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UnitCard unitCard = (UnitCard) o;
        return Objects.equals(name, unitCard.name);
    }

    public int hashCode() {
        return Objects.hash(name, bloodCost, power, health, flavorText);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            this.name = "Creature";
        }
        else {
            this.name = name;
        }
    }

    public int getBloodCost() {
        return bloodCost;
    }

    public void setBloodCost(int bloodCost) {
        if (bloodCost <= 0) {
            this.bloodCost = 0;
        }
        else {
            this.bloodCost = bloodCost;
        }
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        if (power <= 0) {
            this.power = 0;
        }
        else {
            this.power = power;
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health <= 1) {
            this.health = 1;
        }
        else {
            this.health = health;
        }
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }


}
