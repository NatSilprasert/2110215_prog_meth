package entity.counter;

import entity.container.Dish;
import logic.Player;

public class DishWasher extends Counter {
    public DishWasher() {
        super("Dish Washer");
    }

    @Override
    public void interact(Player p) {
        if (!isPlacedContentEmpty()) {
            super.interact(p);
        }
        else if (p.getHoldingItem() instanceof Dish) {
            if (((Dish) p.getHoldingItem()).isDirty()) {
                super.interact(p);
            }
        }
    }

    public void update() {
        if (getPlacedContent() instanceof Dish) {
            ((Dish) getPlacedContent()).clean(15);
        }
    }
}
