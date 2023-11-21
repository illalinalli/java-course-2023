package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class DaysAgoDateParser extends DateParser {
    @Override
    protected Optional<LocalDate> parse(String string) {
        try {
            int days = Integer.parseInt(string.split(" ")[0]);
            LocalDate date = LocalDate.now().minusDays(days);
            return Optional.of(date);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
