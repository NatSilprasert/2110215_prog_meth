package logic.stone;

import logic.game.GameManager;
import utils.GameUtilities;

public class WalkingStone extends Stone {
    public WalkingStone(int posX, int posY) {
        super(posX, posY);
    }

    @Override
    public void dig(int digPower) {
        if (digPower > 1) {
            int score = GameManager.getInstance().getGameScore();
            GameManager.getInstance().setGameScore(score + 1);
        }
        destroy();
    }

    public void walk() {
        GameUtilities.moveWalkingRock(this);
    }
}
