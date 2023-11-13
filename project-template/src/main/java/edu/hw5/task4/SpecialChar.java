package edu.hw5.task4;

public class SpecialChar {
    public static boolean isContainsSpecialChar(String txt) {
        return txt.matches(".*[~!@#$%^&*|].*");
    }
}
