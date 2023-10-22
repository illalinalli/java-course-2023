package edu.hw2_GAME;

import java.util.Scanner;

public class ConsoleHangman {
    private static void printState(GuessResult guess) {
        System.out.println(guess.message());
        System.out.println("The word: " + String.valueOf(guess.state()));
    }
    public static void main(String[] args) {
        String answer = Dictionary.getRandomWord();
        Session session = new Session(answer, 5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Guess a letter:");
            String input = scanner.nextLine();
            if (!input.equals("-1") && input.length() != 1) {
                System.out.println("Please enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            GuessResult result = session.guess(guess);
            printState(result);
            if (result instanceof GuessResult.Defeat || result instanceof GuessResult.Win) {
                break;
            }
            if (input.equals("-1")) {
                GuessResult giveUpResult = session.giveUp();
                printState(giveUpResult);
                break;
            }
        }
    }

}
