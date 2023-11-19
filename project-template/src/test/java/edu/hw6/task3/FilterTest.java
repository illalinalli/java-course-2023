package edu.hw6.task3;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class FilterTest {
    @Test
    void testLargerThan() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        AbstractFilter filter = Filter.largerThan(10);
        assertFalse(filter.accept(tempFile));
        assertTrue(Files.deleteIfExists(tempFile));
    }

    @Test
    void testMagicNumber() throws IOException {
        Path tempFile = Files.createTempFile("test", ".jpg");
        byte[] bytes = new byte[] {(byte)0xFF, (byte)0xD8, (byte)0xFF};
        Files.write(tempFile, bytes);
        AbstractFilter filter = Filter.magicNumber(0xFF, 0xD8, 0xFF);
        assertFalse(filter.accept(tempFile));
    }

    @Test
    void testGlobMatches() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        AbstractFilter filter = Filter.globMatches(".txt");
        assertFalse(filter.accept(tempFile));
    }

    @Test
    void testRegexContains() throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        AbstractFilter filter = Filter.regexContains("es");
        assertTrue(filter.accept(tempFile));
        assertTrue(Files.deleteIfExists(tempFile));
    }

}
