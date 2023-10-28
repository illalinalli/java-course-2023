package edu.hw2_Hangman;

public class ConsoleHangman {
    public static void main(String[] args) {
        String answer = Dictionary.getRandomWord();
        HumanPlayer player = new ConsolePlayer();
        HangmanGame game = new HangmanGame(player, answer, 5);
        game.play();
    }
}
