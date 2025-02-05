package edu.alma.maarouf;

/**
 * Represents the computer player in the Pig game.
 */
public class ComputerPlayer implements GamePlayer{
    private int totalPoints;
    private int turnPoints;

    /**
     * Constructor initializes player points.
     */
    public ComputerPlayer() {
        totalPoints = 0;
        turnPoints = 0;
    }

    /**
     * Takes a turn by rolling the dice until 20 points are accumulated or a 1 is rolled.
     * @param dice the PairOfDice object for rolling.
     */
    @Override
    public void takeTurn(PairOfDice dice) {
        turnPoints = 0;
        boolean keepRolling = true;

        while (keepRolling) {
            int sum = dice.roll();
            System.out.println("Computer player rolled " + dice.getDie1Value() + " and " + dice.getDie2Value());


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
                if (turnPoints >= 20){
                    totalPoints += turnPoints ;
                    keepRolling = false;
                    }
            }


        }
    }



    /**
     * Gets the total points of the computer player.
     * @return total points.
     */
    @Override
    public int getTotalPoints() {
        return totalPoints;
    }
}
