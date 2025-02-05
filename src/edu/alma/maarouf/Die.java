package edu.alma.maarouf;

/**
 * Represents one die (singular of dice) with faces showing between 1 and max value
 */
public class Die {
    private final int MAX;  // maximum face value
    private int faceValue;  // current value shown on die

    /**
     * @param max number of faces on the die. Must be at least 4; otherwise a 6-sided die is created.
     */
    public Die(int max) {
        if (max >= 4) {
            MAX = max;
        } else {
            MAX = 6;
        }
    }

    /**
     * @return the current face value of the die
     */
    public int getFaceValue() {
        return faceValue;
    }



    /**
     * Roll die to produce random value.
     */
    public void roll () {
        faceValue = (int) (Math.random() * MAX) + 1;
    }

    public String toString() {
        return Integer.toString(faceValue);
    }
}
