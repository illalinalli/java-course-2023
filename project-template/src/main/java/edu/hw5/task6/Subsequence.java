package edu.hw5.task6;

import java.util.regex.Pattern;

public class Subsequence {
    public static boolean isSubsequence(String s, String t) {
        StringBuilder pattern = new StringBuilder(".*");
        for (char c : s.toCharArray()) {
            pattern.append(c).append(".*");
        }
        return Pattern.matches(pattern.toString(), t);
    }
}
