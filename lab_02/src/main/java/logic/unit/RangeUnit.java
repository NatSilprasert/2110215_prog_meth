package logic.unit;

import java.util.ArrayList;

public class RangeUnit extends BaseUnit {

    public  RangeUnit(int startColumn, int startRow, boolean isWhite, String name) {
        super(startColumn, startRow, isWhite, name);
        super.hp = 2;
    }

    @Override
    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit targetPiece : targetPieces) {
            if (
                this.isWhite() &&
                targetPiece.getRow() == this.getRow() + 1 &&
                targetPiece.getColumn() == this.getColumn()
            ) {
                System.out.println(this.getName() + " attacks " + targetPiece.getName());
                targetPiece.setHp(targetPiece.getHp() - this.getPower());
            }
            else if (
                !this.isWhite() &&
                targetPiece.getRow() == this.getRow() - 1 &&
                targetPiece.getColumn() == this.getColumn()
            ) {
                System.out.println(this.getName() + " attacks " + targetPiece.getName());
                targetPiece.setHp(targetPiece.getHp() - this.getPower());
            }
            else if (
                !targetPiece.isFlying &&
                targetPiece.getRow() == this.getRow() &&
                targetPiece.getColumn() == this.getColumn()
            ) {
                System.out.println(this.getName() + " attacks " + targetPiece.getName());
                targetPiece.setHp(targetPiece.getHp() - this.getPower());
            }
        }
    }

}
