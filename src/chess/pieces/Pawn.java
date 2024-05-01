package chess.pieces;
import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0, 0);

        if (getColor() == Color.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //First movement two squares
            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) &&
            getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //Diagonal one
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            ////Diagonal two
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //EnPassant WHITE
            if (position.getRow() == 3){

                Position atLeft = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(atLeft) && isThereOpponentPiece(atLeft) &&
                        getBoard().piece(atLeft) == chessMatch.getEnPassantVulnerable()){
                    mat[atLeft.getRow() - 1][atLeft.getColumn()] = true;
                }

                Position atRight = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(atRight) && isThereOpponentPiece(atRight) &&
                        getBoard().piece(atRight) == chessMatch.getEnPassantVulnerable()){
                    mat[atRight.getRow() - 1][atRight.getColumn()] = true;
                }
            }
        } else {
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //First movement two squares
            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) &&
                    getMoveCount() == 0 && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //Diagonal one
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            ////Diagonal two
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            //EnPassant BLACK
            if (position.getRow() == 4){

                Position atLeft = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(atLeft) && isThereOpponentPiece(atLeft) &&
                        getBoard().piece(atLeft) == chessMatch.getEnPassantVulnerable()){
                    mat[atLeft.getRow() + 1][atLeft.getColumn()] = true;
                }

                Position atRight = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(atRight) && isThereOpponentPiece(atRight) &&
                        getBoard().piece(atRight) == chessMatch.getEnPassantVulnerable()){
                    mat[atRight.getRow() + 1][atRight.getColumn()] = true;
                }
            }


        }
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
