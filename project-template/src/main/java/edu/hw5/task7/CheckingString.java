package edu.hw5.task7;

public class CheckingString {
    public static boolean checkString(String str) {
        String regex = "^(0|1)(.|\\1){1}0$";
        return str.matches(regex);
    }
}
