package edu.hw3.task1;
import edu.hw3.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AtbashTest {
    @Test
    public void testAtbashWithLowerCaseLetters() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String expectedOutput = "zyxwvutsrqponmlkjihgfedcba";
        Assertions.assertEquals(expectedOutput, Main.atbash(input));
    }

    @Test
    public void testAtbashWithUpperCaseLetters() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String expectedOutput = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
        assertEquals(expectedOutput, Main.atbash(input));
    }

    @Test
    public void testAtbashWithMixedCaseLetters() {
        String input = "aBcDeFgHiJkLmNoPqRsTuVwXyZ";
        String expectedOutput = "zYxWvUtSrQpOnMlKjIhGfEdCbA";
        assertEquals(expectedOutput, Main.atbash(input));
    }

    @Test
    public void testAtbashWithNonLetterCharacters() {
        String input = "123!@#$%^&*()_+";
        String expectedOutput = "123!@#$%^&*()_+";
        assertEquals(expectedOutput, Main.atbash(input));
    }

    @Test
    public void testAtbashWithEmptyString() {
        String input = "";
        String expectedOutput = "";
        assertEquals(expectedOutput, Main.atbash(input));
    }
}
