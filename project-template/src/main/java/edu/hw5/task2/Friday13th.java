package edu.hw5.task2;

import java.time.LocalDate;

public class Friday13th {
    public static void main(String[] args) {
        int year = 2024; // заданный год
        // начинаем с 13 января заданного года
        LocalDate date = LocalDate.of(year, 1, 13);
        FindFriday13th(date);
    }

    private static void FindFriday13th(LocalDate date) {
        System.out.print("[");
        // перебираем все месяцы года
        for (int month = 1; month <= 12; month++) {
            // проверяем, является ли 13-е число пятницей
            if (date.getDayOfWeek().getValue() == 5 && date.getDayOfMonth() == 13) {
                // если да, выводим его в формате ISO-8601: гггг-мм-дд
                System.out.print(date.toString());
                if (month < 12) {
                    System.out.print(", ");
                }
            }
            // переходим к следующему месяцу
            date = date.plusMonths(1);
        }
        System.out.println("]");
    }
}
