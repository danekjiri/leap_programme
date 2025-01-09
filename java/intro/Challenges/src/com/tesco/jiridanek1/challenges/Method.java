package com.tesco.jiridanek1.challenges;

public class Method {
    public static void main(String[] args) {
        int score1500 = 1_500;
        int score1000 = 1_000;
        int score500 = 500;
        int score100 = 100;
        int score25 = 25;

        displayHighScorePosition("player1500", calculateHighScorePosition(score1500));
        displayHighScorePosition("player1000", calculateHighScorePosition(score1000));
        displayHighScorePosition("player500", calculateHighScorePosition(score500));
        displayHighScorePosition("player100", calculateHighScorePosition(score100));
        displayHighScorePosition("player25", calculateHighScorePosition(score25));
    }

    private static void displayHighScorePosition(String playerName, int playerPosition) {
        System.out.println(playerName + " managed to get into position " + playerPosition
                + " on the high score list.");
    }

    private static int calculateHighScorePosition(int playersScore) {
        int position = 0;

        if (playersScore >= 1_000) {
            position = 1;
        } else if (playersScore >= 500) {
            position = 2;
        } else if (playersScore >= 100) {
            position = 3;
        } else {
            position = 4;
        }
        return position;
    }
}
