package game.piece;

import game.board.Board;
import game.position.Position;

public class Knight extends Piece {
    public Knight(boolean isWhite, Position pos, Board board) {
        super(isWhite, pos, board);
    }

    @Override
    public Object deepCopy() {
        Knight o = new Knight(white, position, board);
        if (isMoved()) o.setMoved(true);
        return o;
    }
}
