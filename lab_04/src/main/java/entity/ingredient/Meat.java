package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Meat extends Ingredient implements Choppable, Cookable {
    private boolean chopState = false;
    private int cookedPercentage = 0;

    public Meat() {
        super("Meat");
    }

    public void chop() {
        if (chopState || cookedPercentage > 0) return;
        chopState = true;
        setName("Minced Meat");
    }

    public boolean isChopped() {
        return chopState;
    }

    public void cook() {
        if (!isChopped()) {
            cookedPercentage += 10;
            if (0 < cookedPercentage && cookedPercentage <= 50) {
                setName("Raw Meat");
                setEdible(false);
            }
            else if (50 < cookedPercentage && cookedPercentage <= 80) {
                setName("Medium Rare Steak");
                setEdible(true);
            }
            else if (80 < cookedPercentage && cookedPercentage <= 100) {
                setName("Well Done Steak");
                setEdible(true);
            }
            else if (cookedPercentage > 100) {
                setName("Burnt Steak");
                setEdible(false);
            }
        }
        else {
            cookedPercentage += 15;
            if (0 < cookedPercentage && cookedPercentage <= 80) {
                setName("Raw Burger");
                setEdible(false);
            } else if (80 < cookedPercentage && cookedPercentage <= 100) {
                setName("Cooked Burger");
                setEdible(true);
            } else if (cookedPercentage > 100) {
                setName("Burnt Burger");
                setEdible(false);
            }
        }
    }

    public boolean isBurnt() {
        return cookedPercentage > 100;
    }

    public String toString() {
        return StringUtil.formatNamePercentage(this.getName(), cookedPercentage);
    }

    public int getCookedPercentage() {
        return cookedPercentage;
    }

    public void setCookedPercentage(int cookedPercentage) {
        this.cookedPercentage = cookedPercentage;
    }
}


