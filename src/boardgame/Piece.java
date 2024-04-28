package boardgame;

public class Piece {

    protected Position position;
    private Board board;

    //Piece position starts null/not placed in the game
    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
