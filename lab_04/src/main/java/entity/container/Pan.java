package entity.container;

import entity.base.Container;
import entity.base.Cookable;
import entity.base.Ingredient;

import java.util.ArrayList;

public class Pan extends Container {
    public Pan() {
        super("Pan", 1);
    }

    public boolean verifyContent(Ingredient i) {
        return (i instanceof Cookable);
    }

    public void cook() {
        ArrayList<Ingredient> items = this.getContent();
        for (Ingredient i : items) {
            if (i instanceof Cookable) ((Cookable) i).cook();
        }
    }
}
