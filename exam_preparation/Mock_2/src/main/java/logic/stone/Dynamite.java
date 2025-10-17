package logic.stone;

import utils.GameUtilities;

import java.util.ArrayList;

public class Dynamite extends Stone {
    public Dynamite(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void destroy() {
        ArrayList<Stone> removedStone = GameUtilities.getAdjacentStones(this.posX, this.posY);
        for (Stone stone : removedStone) {
            GameUtilities.removeStone(stone);
        }
        GameUtilities.removeStone(this);
    }
}
