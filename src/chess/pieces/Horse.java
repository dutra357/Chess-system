package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Horse extends ChessPiece {


    public Horse(Board board, Color color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "H";
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != getColor();
    }

    //Other solution
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        for (int i = -2; i <= 2; i += 4) {
            for (int j = -1; j <= 1; j += 2) {
                p.setValues(position.getRow() - i, position.getColumn() + j);
                if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)))
                    mat[p.getRow()][p.getColumn()] = true;
            }
        }

        for (int i = -1; i <= 1; i += 2) {
            for (int j = -2; j <= 2; j += 4) {
                p.setValues(position.getRow() - i, position.getColumn() + j);
                if (getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p)))
                    mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }
}
