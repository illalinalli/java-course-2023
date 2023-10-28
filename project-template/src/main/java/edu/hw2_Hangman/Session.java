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
    public String getAnswer() {
        return answer;
    }
    public char[] getUserAnswer() {
        return userAnswer;
    }

    public int getAttempts() {
        return attempts;
    }

    public int getMaxAttempts() {
        return maxAttempts;
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
                return GuessResult.WIN;
            } else {
                return GuessResult.SUCCESSFUL_GUESS;
            }
        } else {
            if (attempts >= maxAttempts) {
                return GuessResult.DEFEAT;
            } else {
                return GuessResult.FAILED_GUESS;
            }
        }
    }

   /* public GuessResult giveUp() {
        return GuessResult.GAVE_UP;
    }*/
}
