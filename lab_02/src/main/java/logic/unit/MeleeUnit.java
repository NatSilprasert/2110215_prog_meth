package logic.unit;

public class MeleeUnit extends BaseUnit {

    public MeleeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        super.power = 2;
        super.hp = 5;
    }

}
