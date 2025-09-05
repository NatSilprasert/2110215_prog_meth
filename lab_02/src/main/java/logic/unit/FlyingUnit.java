package logic.unit;

public class FlyingUnit extends BaseUnit {

    public FlyingUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        super.isFlying = true;
        super.hp = 2;
    }

    @Override
    public boolean move(int direction) {
        if  (direction == 0 && this.getRow() + 2 < 5) {
            this.setRow(this.getRow() + 2);
            return true;
        }
        else if (direction == 1 && this.getColumn() + 2 < 5) {
            this.setColumn(this.getColumn() + 2);
            return true;
        }
        else if (direction == 2 && this.getRow() - 2 > -1) {
            this.setRow(this.getRow() - 2);
            return true;
        }
        else if (direction == 3 && this.getColumn() - 2 > -1) {
            this.setColumn(this.getColumn() - 2);
            return true;
        }
        return  false;
    }

}
