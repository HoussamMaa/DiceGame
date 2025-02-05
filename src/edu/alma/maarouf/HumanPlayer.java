package edu.alma.maarouf;
import java.util.Scanner;


/**
 * Represents the human player in the Pig game.
 */
public class HumanPlayer implements GamePlayer{
    private int totalPoints;
    private int turnPoints;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor initializes player points and scanner for input.
     */
    public HumanPlayer() {
        totalPoints = 0;
        turnPoints = 0;
    }

    // Implement the takeTurn method from GamePlayer interface
    @Override
    public void takeTurn(PairOfDice dice) {
        turnPoints = 0;
        boolean keepRolling = true;

        while (keepRolling) {
            System.out.println("Current points: " + totalPoints);
            System.out.println("Turn points: " + turnPoints);
            System.out.println("Roll or Pass (r/p)? ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("r")) {
                int sum = dice.roll();
                System.out.println("Rolled " + dice.getDie1Value() + " and " + dice.getDie2Value());

                if (dice.getDie1Value() == 1 && dice.getDie2Value() == 1){
                    System.out.println("Snake eyes! You lose all points!");
                    totalPoints = 0;
                    break;
                } else if (dice.getDie1Value() == 1 || dice.getDie2Value() == 1) {
                    System.out.println("Rolled a 1! Turn points lost.");
                    //turnPoints = 0;
                    break;
                } else {
                    turnPoints += sum;
                }


            } else {
                totalPoints += turnPoints;
                keepRolling = false;
            }

        }
    }


    /**
     * Gets the total points of the player.
     * @return total points.
     */
    @Override
    public int getTotalPoints() {
        return totalPoints;
    }
}


