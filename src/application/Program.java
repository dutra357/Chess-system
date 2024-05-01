package application;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);

                System.out.println();

                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMovies = chessMatch.possibleMovies(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMovies);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if(capturedPiece != null) {
                    captured.add(capturedPiece);
                }

                System.out.println();

                //Opportunity to choose a new piece
                if (chessMatch.getPiecePromoted() != null) {
                    System.out.print("Enter your option for promotion (B/H/R/Q): ");
                    String typePiece = sc.nextLine().toUpperCase();

                    while (!typePiece.equals("B") && !typePiece.equals("H") &&
                            !typePiece.equals("R") && !typePiece.equals("Q")) {
                        System.out.print("Invalid charcter. Type a valid option for promotion (B/H/R/Q): ");
                        typePiece = sc.nextLine().toUpperCase();
                    }

                    chessMatch.replacePromotedPiece(typePiece);
                }

            } catch (ChessException | InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }

            UI.clearScreen();
            UI.printMatch(chessMatch, captured);
        }

    }
}
