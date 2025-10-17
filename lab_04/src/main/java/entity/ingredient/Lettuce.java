package entity.ingredient;

import entity.base.Choppable;
import entity.base.Cookable;
import entity.base.Ingredient;

public class Lettuce extends Ingredient implements Choppable {
    private boolean chopState;

    public Lettuce() {
        super("Lettuce");
        setEdible(true);
        chopState = false;
    }

    public void chop() {
        if (chopState) return;
        chopState = true;
        setName("Chopped Lettuce");
    }

    public boolean isChopped() {
        return chopState;
    }


}
