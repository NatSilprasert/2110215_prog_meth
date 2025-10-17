package entity.counter;

import entity.base.Container;
import entity.base.Ingredient;
import logic.Player;

public class Bin extends Counter {
    public Bin() {
        super("Bin");
    }

    @Override
    public void interact(Player p) {
        if (p.isHandEmpty()) return;
        if (p.getHoldingItem() instanceof Ingredient) p.setHoldingItem(null);
        else if (p.getHoldingItem() instanceof Container) ((Container) p.getHoldingItem()).clearContent();
    }
}
