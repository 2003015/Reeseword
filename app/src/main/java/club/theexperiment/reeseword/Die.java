package club.theexperiment.reeseword;

import android.net.Uri;

import java.util.Random;

public abstract class Die {
    //Declare variables
    private int sides;
    private Random rand = new Random();
    private String word;
    private int[] rolls;
    //Create constructor
    public Die() {
        sides = 0;
    }


    //Getters and Setters

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int[] getRolls() {return rolls;}

    public String getWord() {return word;}

    public void setWord(String word) {this.word = word;}

    //Generate array of random ints when rolled

    public void roll(int r) {
        boolean cont = true;
        rolls = new int[this.sides];
        for (int x : rolls) {
            rolls[x] = 0;
        }

        for (int i = 0; i < r; i++) {
            int n = rand.nextInt(this.sides) + 1;
            rolls[n - 1]++;
        }
    }
}
