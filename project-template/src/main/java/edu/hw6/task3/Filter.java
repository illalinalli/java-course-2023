package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Filter {
    public static AbstractFilter largerThan(long size) {
        return (entry) -> {
            try {
                return Files.size(entry) > size;
            } catch (IOException e) {
                return false;
            }
        };
    }

    public static AbstractFilter magicNumber(int... magic) {
        return entry -> {
            byte[] bytes = Files.readAllBytes(entry);
            if (bytes.length < magic.length) {
                return false;
            }
            for (int i = 0; i < magic.length; i++) {
                if (bytes[i] != magic[i]) {
                    return false;
                }
            }
            return true;
        };
    }

    public static AbstractFilter globMatches(String glob) {
        return (entry) -> {
            Path fileName = entry.getFileName();
            return fileName != null && fileName.toString().matches(glob);
        };
    }
    public static AbstractFilter regexContains(String regex) {
        return (entry) -> {
            Path fileName = entry.getFileName();
            return fileName != null && fileName.toString().matches(".*" + regex + ".*");
        };
    }
}
