package logic.stone;

import logic.game.GameManager;
import utils.GameUtilities;

public class Gear extends HardStone {
    int upgradeValue;

    public Gear(int posX, int posY) {
        super(posX, posY, 2);
        upgradeValue = 1;
    }

    public Gear(int posX, int posY, int upgradeValue) {
        super(posX, posY, 2);
        setUpgradeValue(upgradeValue);
    }

    @Override
    public void destroy() {
        GameUtilities.removeStone(this);
        GameManager.getInstance().addDigPower(upgradeValue);
    }

    public int getUpgradeValue() {
        return upgradeValue;
    }

    public void setUpgradeValue(int upgradeValue) {
        this.upgradeValue = Math.max(1, upgradeValue);
    }
}
