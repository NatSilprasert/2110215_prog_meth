package entity.counter;

import entity.base.Ingredient;
import logic.LogicUtil;
import logic.Player;

public class Crate extends Counter {
    private String  myIngredient;

    public Crate(String s) {
        myIngredient = s;
        setName(this.myIngredient + " Crate" );
    }

    @Override
    public void interact(Player p) {
        if (!p.isHandEmpty() || !this.isPlacedContentEmpty()) super.interact(p);
        else {
            try {
                p.setHoldingItem(LogicUtil.createIngredientFromName(myIngredient));
            }
            catch (Exception e) {
                p.setHoldingItem(null);
            }
        }
    }

    public String getMyIngredient() {
        return myIngredient;
    }

    public void setMyIngredient(String myIngredient) {
        this.myIngredient = myIngredient;
    }
}
