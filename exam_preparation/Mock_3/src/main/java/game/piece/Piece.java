package game.piece;

import game.board.Board;
import game.position.Position;
import game.util.Movement;

import java.util.Objects;
import java.util.Set;

public class Piece {
    protected boolean white;
    protected boolean moved;
    protected Position position;
    protected Board board;

    public Piece(boolean white, Position position, Board board) {
        setWhite(white);
        setPosition(position);
        setBoard(board);

        board.placePiece(this, position);
    }

    public Set<Position> getLegalMove() {
        Movement m = new Movement(position, board);
        m.getMovePositions(this);
        return m.getMoves();
    }

    public Object deepCopy() {
        return new Piece(white, position, board);
    }

    public String toString() {
        return getClass().getSimpleName() + position;
    }

    public void moveHandle(Position to) {
        setMoved(hadMoved());
        setPosition(to);
    }

    public boolean hadMoved() {
        setMoved(true);
        return true;
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return white == piece.white && moved == piece.moved && Objects.equals(position, piece.position) && Objects.equals(board, piece.board);
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public boolean isMoved() {
        return moved;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}
