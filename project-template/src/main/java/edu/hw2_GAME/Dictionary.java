package edu.hw2_GAME;

import java.util.Random;

public class Dictionary {
    private static final String[] WORDS = {"hello", "world", "java", "programming", "computer"};
    private static final Random RANDOM = new Random();

    public static String getRandomWord() {
        return WORDS[RANDOM.nextInt(WORDS.length)];
    }
}
