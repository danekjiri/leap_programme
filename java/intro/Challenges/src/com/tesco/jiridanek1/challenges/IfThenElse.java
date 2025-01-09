package com.tesco.jiridanek1.challenges;

/**
 * TASK:
 * Insert a code segment after the code we've just reviewed:
 * Set the existing score variable to 10,000.
 * Set the existing levelCompleted variable to 8.
 * Set the existing bonus variable to 200.
 * Use the same if condition. Meaning if gameOver is true, then you want to perform the same calculation,
 *  and print out the value of the finalScore variable.
 */

public class IfThenElse {
    public static void main(String[] args) {
        /// init variables and copy-paste task template
        boolean gameOver = true;
        int score = 800;
        int levelCompleted = 5;
        int bonus = 100;

        int finalScore = score;

        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        /// reassign defined variables
        score = 10_000;
        levelCompleted = 8;
        bonus = 200;

        /// reassign the new score value as `finalScore`
        finalScore = score;

        /// output the final score as before
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}
