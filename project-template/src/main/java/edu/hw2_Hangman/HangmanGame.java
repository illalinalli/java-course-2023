package edu.hw2_Hangman;

public class HangmanGame {
    private final String answer;
    private final char[] userAnswer;
    private final int maxAttempts;
    private int attempts;
    private final HumanPlayer player;

    public HangmanGame(HumanPlayer player, String answer, int maxAttempts) {
        this.player = player;
        this.answer = answer;
        this.userAnswer = new char[answer.length()];
        for (int i = 0; i < answer.length(); i++) {
            userAnswer[i] = '*';
        }
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    public void play() {
        while (true) {
            String guess = player.guess();
            if (guess.equals("-1")) {
                GuessResult giveUpResult = GuessResult.GAVE_UP;
                printState(giveUpResult, userAnswer, attempts, maxAttempts, answer);
                break;
            }
            if (!guess.equals("-1") && guess.length() != 1) {
                System.out.println("Please enter a single letter.");
                break;
            }
            GuessResult result = guess(guess);
            printState(result, getUserAnswer(), getAttempts(), getMaxAttempts(), getAnswer());
            if (result == GuessResult.DEFEAT || result == GuessResult.WIN) {
                break;
            }
        }
    }

    private void printState(GuessResult guess, char[] userAnswer, int attempts, int maxAttempts, String answer) {
        System.out.println(guess.getMessage());
        if (guess == GuessResult.DEFEAT || guess == GuessResult.GAVE_UP) {
            System.out.println("The word: " + answer);
        } else {
            System.out.println("The word: " + String.valueOf(userAnswer));
        }

        if (guess == GuessResult.FAILED_GUESS) {
            System.out.println(String.format(guess.getMessage(), attempts, maxAttempts)
                + "Missed, mistake " + attempts + " out of " + maxAttempts + ".");
        }
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

    public GuessResult guess(String guess) {
        boolean hit = false;
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == guess.charAt(0)) {
                userAnswer[i] = guess.charAt(0);
                hit = true;
            }
        }
        if (!hit){
            attempts++;
        }

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

    /*public GuessResult giveUp() {
        return GuessResult.GAVE_UP;
    }*/
}
