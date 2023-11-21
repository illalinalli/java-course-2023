package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class YesterdayDateParser extends DateParser {
    @Override
    protected Optional<LocalDate> parse(String string) {
        if (string.equalsIgnoreCase("yesterday")) {
            return Optional.of(LocalDate.now().minusDays(1));
        } else {
            return Optional.empty();
        }
    }
}
