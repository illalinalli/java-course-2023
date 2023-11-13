package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class DateParser {
    private DateParser next;

    public DateParser linkWith(DateParser next) {
        this.next = next;
        return next;
    }

    public Optional<LocalDate> tryParse(String string) {
        Optional<LocalDate> parsedDate = parse(string);
        if (parsedDate.isPresent()) {
            return parsedDate;
        } else if (next != null) {
            return next.tryParse(string);
        } else {
            return Optional.empty();
        }
    }

    abstract protected Optional<LocalDate> parse(String string);
}
