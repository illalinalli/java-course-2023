package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public class DateParserChain {
    private final DateParser parserChain = new IsoDateParser();

    public DateParserChain() {
        parserChain.linkWith(new LongIsoDateParser())
            .linkWith(new ShortIsoDateParser())
            .linkWith(new AmericanDateParser())
            .linkWith(new ShortAmericanDateParser())
            .linkWith(new TomorrowDateParser())
            .linkWith(new TodayDateParser())
            .linkWith(new YesterdayDateParser())
            .linkWith(new DaysAgoDateParser());
    }

    public Optional<LocalDate> parseDate(String string) {
        return parserChain.tryParse(string);
    }
}
