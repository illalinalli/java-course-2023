package edu.hw3.task4;
import edu.hw3.Main;
import org.junit.jupiter.api.Test;
import static edu.hw3.Main.convertToRoman;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class convertToRomanTest {
    @Test
    public void test1() {
        int number = 1;
        String expected = "I";
        String actual = convertToRoman(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test2() {
        int number = 10;
        String expected = "X";
        String actual = convertToRoman(number);
        assertEquals(expected, actual);
    }
    @Test
    public void test3() {
        int number = 3999;
        String expected = "MMMCMXCIX";
        String actual = convertToRoman(number);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int number = 0;
        String expected = "";
        String actual = convertToRoman(number);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int number = -10;
        String expected = "";
        String actual = convertToRoman(number);
        assertEquals(expected, actual);
    }
}
