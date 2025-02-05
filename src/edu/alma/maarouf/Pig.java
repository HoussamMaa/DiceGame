/**
 * Pig.java -- a basic testbed for creating Lab 1 game
 * Houssam Maa
 * CSC230 F24
 * 9/11/24
 * Lab 1
 */
package edu.alma.maarouf;

import java.util.Scanner;

public class Pig {

    public static void main(String[] args) {
        Pig game = new Pig();
        game.start();
    }

    /**
     * Starts the Pig game, initializing players and running the main game loop.
     */
    public void start() {
        PairOfDice dice = new PairOfDice();
        Scanner scanner = new Scanner(System.in);

        // Declare two GamePlayer references
        GamePlayer player1;
        GamePlayer player2;

        // Choosing the type of the game
        System.out.println("Welcome to the Pig game! First to reach 100 points wins.");
        System.out.println("Select game mode: ");
        System.out.println("1: Human vs Human");
        System.out.println("2: Human vs Computer");
        System.out.println("3: Computer vs Computer");
        System.out.println("Enter your choice(1,2, or 3): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1: // Human vs Human
                player1 = new HumanPlayer();
                player2 = new HumanPlayer();
                break;
            case 2: // Human vs Computer
                player1 = new HumanPlayer();
                player2 = new ComputerPlayer();
                break;
            case 3: // Computer vs Computer
                player1 = new ComputerPlayer();
                player2 = new ComputerPlayer();
                break;
            default:
                System.out.println("Invalid choice! Defaulting to Human vs Computer");
                player1 = new HumanPlayer();
                player2 = new ComputerPlayer();
        }

        // Main game loop
        while (true) {
            // player1's turn
            System.out.println("\n--- Player1's turn ---");
            player1.takeTurn(dice);
            System.out.println("Player1 total points: " + player1.getTotalPoints());
            if (player1.getTotalPoints() >= 100){
                System.out.println("Player 1 wins!");
                break;
            }


            // player2's turn
            System.out.println("\n--- Player2's turn ---");
            player2.takeTurn(dice);
            System.out.println("Player2 total points: " + player2.getTotalPoints());
            if (player2.getTotalPoints() >= 100){
                System.out.println("Player 2 wins!");
                break;
            }
        }
    }

}
