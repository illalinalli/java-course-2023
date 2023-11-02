package edu.hw2_Hangman;

public enum GuessResult {
    WIN("You won!"),
    DEFEAT("You lost!"),
    SUCCESSFUL_GUESS("Hit!"),
    FAILED_GUESS(""),
    GAVE_UP("You gave up!");

    private final String message;

    GuessResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
