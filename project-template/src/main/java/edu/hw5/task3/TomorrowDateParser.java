package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class TomorrowDateParser extends DateParser {
    @Override
    protected Optional<LocalDate> parse(String string) {
        if (string.equalsIgnoreCase("tomorrow")) {
            return Optional.of(LocalDate.now().plusDays(1));
        } else {
            return Optional.empty();
        }
    }
}
