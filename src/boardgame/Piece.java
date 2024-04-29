package boardgame;

public abstract class Piece {

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

    public abstract boolean[][] possibleMovies();

    public boolean possibleMovie(Position position) {
        return possibleMovies()[position.getRow()][position.getColumn()];
    }

    public boolean isThereAnyPossibleMove(){
        boolean[][] mat = possibleMovies();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                if(mat[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
