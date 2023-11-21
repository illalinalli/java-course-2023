package edu.hw5.task3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class IsoDateParser extends DateParser {
    @Override
    protected Optional<LocalDate> parse(String string) {
        try {
            LocalDate date = LocalDate.parse(string, DateTimeFormatter.ISO_LOCAL_DATE);
            return Optional.of(date);
        } catch (DateTimeParseException e) {
            return Optional.empty();
        }
    }
}
