package edu.hw5.task1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ComputerClubAnalytics {
    public static String avgSessionDuration(List<String> sessions) {
        int totalSeconds = 0;
        for (String session : sessions) {
            LocalDateTime start = LocalDateTime.parse(session.split(" - ")[0], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
            LocalDateTime end = LocalDateTime.parse(session.split(" - ")[1], DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm"));
            Duration duration = Duration.between(start, end);
            totalSeconds += duration.getSeconds();
        }
        Duration avgDuration = Duration.ofSeconds(totalSeconds / sessions.size());
        long hours = avgDuration.toHours();
        long minutes = avgDuration.toMinutesPart();
        return hours + "ч " + minutes + "м";
    }

    public static void main(String[] args) {
        List<String> sessions = List.of(
            "2022-03-12, 20:20 - 2022-03-12, 23:50",
            "2022-04-01, 21:30 - 2022-04-02, 01:20"
        );
        String avgDuration = avgSessionDuration(sessions);
        System.out.println(avgDuration);
    }
}
