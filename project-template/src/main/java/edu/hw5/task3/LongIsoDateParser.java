package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class LongIsoDateParser extends DateParser {
    @Override
    protected Optional<LocalDate> parse(String string) {
        try {
            LocalDate date = LocalDate.parse(string, DateTimeFormatter.ofPattern("uuuu-M-dd"));
            return Optional.of(date);
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }
}
