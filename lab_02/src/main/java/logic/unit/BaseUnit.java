package logic.unit;

import java.util.ArrayList;

public class BaseUnit {
    private int row;
    private int col;
    boolean isWhite;
    private String name;
    protected int hp;
    protected int power;
    boolean isFlying;

    public BaseUnit(int startColumn, int startRow, boolean isWhite, String name) {
        setColumn(startColumn);
        setRow(startRow);
        setWhite(isWhite);
        setName(name);
        setHp(2);
        this.isFlying = false;
        this.power = 1;
    }

    public boolean move(int direction) {
        if  (direction == 0 && row + 1 < 5) {
            setRow(row + 1);
            return true;
        }
        else if (direction == 1 && col + 1 < 5) {
            setColumn(col + 1);
            return true;
        }
        else if (direction == 2 && row - 1 > -1) {
            setRow(row - 1);
            return true;
        }
        else if (direction == 3 && col - 1 > -1) {
            setColumn(col - 1);
            return true;
        }
        return  false;
    }

    public void attack(ArrayList<BaseUnit> targetPieces) {
        for (BaseUnit targetPiece : targetPieces) {
            if (!targetPiece.isFlying && targetPiece.getRow() == row && targetPiece.getColumn() == col) {
                System.out.println(this.getName() + " attacks " + targetPiece.getName());
                targetPiece.setHp(targetPiece.getHp() - this.getPower());
            }
        }
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        if (row < 0) {
           this.row = 0;
        }
        else {
            this.row = Math.min(row, 4);
        }
    }

    public int getColumn() {
        return col;
    }

    public void setColumn(int col) {
        if (col < 0) {
            this.col = 0;
        }
        else {
            this.col = Math.min(col, 4);
        }
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getPower() {
        return power;
    }

    public boolean isFlying() {
        return isFlying;
    }

}
