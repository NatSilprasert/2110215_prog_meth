package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;
import logic.StringUtil;

public class Egg extends Ingredient implements Cookable {
    private int cookedPercentage = 0;

    public Egg() {
        super("Egg");
    }

    public void cook() {
        cookedPercentage += 12;
        if (0 < cookedPercentage && cookedPercentage <= 50) {
            setName("Raw Egg");
            setEdible(false);
        }
        else if (50 < cookedPercentage && cookedPercentage <= 80) {
            setName("Sunny Side Egg");
            setEdible(true);
        }
        else if (80 < cookedPercentage && cookedPercentage <= 100) {
            setName("Fried Egg");
            setEdible(true);
        }
        else if (cookedPercentage > 100) {
            setName("Burnt Egg");
            setEdible(false);
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
