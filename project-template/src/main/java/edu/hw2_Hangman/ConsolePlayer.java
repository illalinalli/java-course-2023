package edu.hw2_Hangman;

import java.util.Scanner;

public class ConsolePlayer implements HumanPlayer {
    private final Scanner scanner;

    public ConsolePlayer() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String guess() {
        System.out.println("Guess a letter:");
        String input = scanner.nextLine();
        if (!input.equals("-1") && input.length() != 1) {
            System.out.println("Please enter a single letter.");
            return guess();
        }
        return input;
    }
}
