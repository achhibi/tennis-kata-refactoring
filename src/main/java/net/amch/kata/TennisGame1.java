package net.amch.kata;

import java.util.Map;

public class TennisGame1 implements TennisGame {

    private static final String ALL = "All";
    private static final String DEUCE = "Deuce";
    private static final String LOVE = "Love";
    private static final String FIFTEEN = "Fifteen";
    private static final String THIRTY = "Thirty";
    private static final String FORTY = "Forty";


    private static final String ADVANTAGE = "Advantage ";
    private static final String WIN = "Win for ";

    private static final Map<Integer, String> SCORES = Map.of(0, LOVE, 1, FIFTEEN, 2, THIRTY, 3, FORTY);
    private static final String SCORE_SEPERATOR = "-";


    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }


    public void wonPoint(String playerName) {
        if (player1Name.equals(playerName)) player1Score += 1;
        else player2Score += 1;
    }

    public String score() {
        if (player1Score == player2Score) {
            return equalitySCore();
        }
        if (player1Score >= 4 || player2Score >= 4) {
            return endScore();
        }
        return middleScore();
    }

    private String equalitySCore() {

        if (player1Score >= 3) {
            return DEUCE;
        }
        return SCORES.get(player1Score) + SCORE_SEPERATOR + ALL;
    }

    private String endScore() {
        int player1Advantage = player1Score - player2Score;
        if (Math.abs(player1Advantage) == 1) {
            return ADVANTAGE + advantagePlayer();
        }
        return WIN + advantagePlayer();
    }

    private String middleScore() {
        return SCORES.get(player1Score) + SCORE_SEPERATOR + SCORES.get(player2Score);
    }

    private String advantagePlayer() {
        return player1Score > player2Score ? player1Name : player2Name;
    }
}
