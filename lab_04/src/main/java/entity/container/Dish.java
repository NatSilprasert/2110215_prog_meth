package entity.container;

import entity.base.Container;
import entity.base.Ingredient;
import logic.StringUtil;

public class Dish extends Container {
    private int dirty = 0;

    public Dish() {
        super("Dish", 4);
    }

    public Dish(int dirty) {
        super("Dirty Dish", 4);
        setDirty(dirty);
    }

    public boolean isDirty() {
        return dirty > 0;
    }

    public boolean verifyContent(Ingredient i) {
        return (!isDirty() && i.isEdible());
    }

    public void setDirty(int dirty) {
        this.dirty = Math.max(0, dirty);
        if (this.dirty == 0) {
            setName("Dish");
        }
        else {
            setName("Dirty Dish");
        }
    }

    public void clean(int amount) {
        setDirty(dirty - amount);
    }

    public String toString() {
        if (isDirty()) return StringUtil.formatNamePercentage(this.getName(), dirty);
        else return super.toString();
    }

    public int getDirty() {
        return dirty;
    }
}
