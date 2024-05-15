package org.example.navalbattle.model;

/**
 * Represents the main game logic for the Naval Battle game.
 * This class manages the game state, player actions, and game mechanics.
 */
public class Game implements IGame {
    private int size; //battlefield size, row and columns
    private char[][] board; //register


    private void initializeBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                board[row][col] = ' '; // position with no boards
            }
        }
    }

    public void printBoard() {
        System.out.println("  A B C D E F G H I J");
        for (int row = 0; row < size; row++) {
            System.out.print(row + 1 + " "); // row numbers
            for (int col = 0; col < size; col++) {
                System.out.print(board[row][col] + " "); // content of each position
            }
            System.out.println();
        }
    }
}
