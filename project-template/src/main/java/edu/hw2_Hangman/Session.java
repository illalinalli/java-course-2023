package edu.hw2_Hangman;

public class Session {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;

    public Session(String answer, int maxAttempts) {
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '*';
        }
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    public GuessResult guess(char guess) {
        boolean hit = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess) {
                userAnswer[i] = guess;
                hit = true;
            }
        }
        attempts++;
        if (hit) {
            if (String.valueOf(userAnswer).equals(answer)) {
                return new GuessResult.Win(userAnswer, attempts, maxAttempts, "You won!");
            } else {
                return new GuessResult.SuccessfulGuess(userAnswer, attempts, maxAttempts, "Hit!");
            }
        } else {
            if (attempts >= maxAttempts) {
                return new GuessResult.Defeat(answer.toCharArray(), attempts, maxAttempts, "You lost!");
            } else {
                return new GuessResult.FailedGuess(userAnswer, attempts, maxAttempts, "Missed, mistake " + attempts + " out of " + maxAttempts + ".");
            }
        }
    }

    public GuessResult giveUp() {
        return new GuessResult.Defeat(answer.toCharArray(), attempts, maxAttempts, "You gave up!");
    }
}
