package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class TodayDateParser extends DateParser {
    @Override
    protected Optional<LocalDate> parse(String string) {
        if (string.equalsIgnoreCase("today")) {
            return Optional.of(LocalDate.now());
        } else {
            return Optional.empty();
        }
    }
}
