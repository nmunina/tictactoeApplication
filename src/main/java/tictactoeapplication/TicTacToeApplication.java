package tictactoeapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToeApplication {

    public static void main(String[] args) throws IOException {

        // getting inputs
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean doYouWantToPlay = true;

        while (doYouWantToPlay) {
            System.out.println("WElcome to Tic Tac Toe. You are about to go against "
                    + "the master of Tic Tac Toe. Are your ready? \n" +
                    "But first you must pick up the caracter you want to be and which character I will be.");

            System.out.println("Enter a single character that will represent you");
            char playerToken = (char) reader.read();
            System.out.println("Enter the character that will represent your opponent on the board");
            char opponentToken = (char) reader.read();

            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            AI ai = new AI();

            // set up the game
            System.out.println("Now we can start the game. To play enter a number and your toked shall be pu in ints place. \n" +
                    "The numbers go from 1 to 9, from left to right. We shall see who will winn this round.");
            TicTacToe.printIndexBoard();
            System.out.println("Let's play.");

            while (game.gameOver().equals("notOver")) {
                if (game.currentMarker == game.userMarker) {
                    // user turn
                    System.out.println("It's your turn. Enter a spot for your token.");
                    int spot = Integer.parseInt(reader.readLine());

                    while (!game.playTurn(spot)) {
                        System.out.println("Try again. " + spot + " is invalid or out of range.");
                        spot = Integer.parseInt(reader.readLine());
                    }

                    System.out.println("You picked " + spot + "!");
                } else {
                    // Ai turn
                    System.out.println("It's my turn");
                    // pick spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("I picked " + aiSpot + " !");
                }

                // Print out new board.
                System.out.println();
                game.printBoard();
            }

            System.out.println(game.gameOver());
            System.out.println();

            // set up a new game (or not)

            System.out.println("Do you want to play again? Print Y if you do, or anything else if you are tired.");

            char response = (char) reader.read();

            doYouWantToPlay = (response == 'Y');
            System.out.println();
            System.out.println();
            


        }
    }

}
