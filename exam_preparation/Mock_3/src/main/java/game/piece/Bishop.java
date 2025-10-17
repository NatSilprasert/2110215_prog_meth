package game.piece;

import game.board.Board;
import game.position.Position;

public class Bishop extends Piece {
    public Bishop(boolean isWhite, Position pos, Board board) {
        super(isWhite, pos, board);
    }

    @Override
    public Object deepCopy() {
        Bishop o = new Bishop(white, position, board);
        if (isMoved()) o.setMoved(true);
        return o;
    }
}
