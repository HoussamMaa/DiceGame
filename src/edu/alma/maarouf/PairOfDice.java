package edu.alma.maarouf;

public class PairOfDice {
    private final Die first_die;
    private final Die second_die;

    public PairOfDice() {
        first_die = new Die(6);
        second_die = new Die(6);
    }

    /**
     * Rolls both dice.
     * @return the sum of the dice values.
     */
    public int roll(){
        first_die.roll();
        second_die.roll();
        return getSum();
    }

    /**
     * Returns the sum of the two dice values.
     * @return the sum of die1 and die2.
     */
    public int getSum(){ return first_die.getFaceValue() + second_die.getFaceValue();}

    /**
     * Returns the value of the first die.
     * @return value of die1.
     */
    public int getDie1Value(){return first_die.getFaceValue();}

    /**
     * Returns the value of the second die.
     * @return value of die2.
     */
    public int getDie2Value(){return second_die.getFaceValue();}
}
