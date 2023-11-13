package edu.hw5;

import edu.hw5.task3.DateParserChain;
import edu.hw5.task5.RussianLicensePlateValidator;
import edu.hw5.task6.Subsequence;
import java.time.LocalDate;
import java.util.Optional;
import static edu.hw5.task4.SpecialChar.isContainsSpecialChar;
import static edu.hw5.task7.CheckingString.checkString;

public class Main {
    public static void main(String[] args) {
        // task 3
        DateParserChain parser = new DateParserChain();

        Optional<LocalDate> date1 = parser.parseDate("2020-10-10");
        Optional<LocalDate> date2 = parser.parseDate("2020-12-2");
        Optional<LocalDate> date3 = parser.parseDate("1/3/1976");
        Optional<LocalDate> date4 = parser.parseDate("1/3/20");
        Optional<LocalDate> date5 = parser.parseDate("tomorrow");
        Optional<LocalDate> date6 = parser.parseDate("today");
        Optional<LocalDate> date7 = parser.parseDate("yesterday");
        Optional<LocalDate> date8 = parser.parseDate("1 day ago");
        Optional<LocalDate> date9 = parser.parseDate("2234 days ago");

        System.out.println(date1);
        System.out.println(date2);
        System.out.println(date3);
        System.out.println(date4);
        System.out.println(date5);
        System.out.println(date6);
        System.out.println(date7);
        System.out.println(date8);
        System.out.println(date9);

        // task 4
        String password = "myPassword1#";
        System.out.println(isContainsSpecialChar(password));

        // task 5
        String licensePlateNumber = "123АВЕ777";
        RussianLicensePlateValidator validator = new RussianLicensePlateValidator();
        boolean isValid = validator.isValidRussianLicensePlate(licensePlateNumber);
        if (isValid) {
            System.out.println("The license plate number is valid");
        } else {
            System.out.println("The license plate number is not valid");
        }

        // task 6
        String s = "abc";
        String t = "ahabagdaca";
        boolean isSub = Subsequence.isSubsequence(s, t);
        String result = isSub ? "is" : "is not";
        System.out.println("'" + s + "' " + result + " a subsequence of '" + t + "'");

        // task 7
        String str1 = "010";
        String str2 = "0110";
        String str3 = "00110";

        System.out.println(checkString(str1));
        System.out.println(checkString(str2));
        System.out.println(checkString(str3));
    }
}
