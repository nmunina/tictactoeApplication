package tictactoeapplication;

import java.util.ArrayList;
import java.util.Random;

public class AI {
    public int pickSpot(TicTacToe game){
        ArrayList<Integer> choices = new ArrayList<Integer>();

        for (int i = 0; i < 9; i++) {
            // if the spot is not taken, take it as a choise
            if(game.board[i] == '-') {
                choices.add(i+1);
            }
        }

        Random rnd = new Random();
        int choice = choices.get(Math.abs(rnd.nextInt() % choices.size()));

        return choice;

    }
}
