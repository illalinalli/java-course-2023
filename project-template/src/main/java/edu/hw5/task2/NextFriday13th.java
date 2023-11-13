package edu.hw5.task2;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class NextFriday13th {
    public static LocalDate findNextFridayTheThirteenth(LocalDate date) {
        LocalDate nextFriday;
        if (date.getDayOfMonth() >= 13) {
            nextFriday = date.plusMonths(1).withDayOfMonth(13);
        } else {
            nextFriday = date.withDayOfMonth(13);
        }
        return nextFriday.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
    }

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate nextFriday = findNextFridayTheThirteenth(date);
        System.out.println("Next Friday the 13th after " + date + ": " + nextFriday);
    }
}
