package edu.hw3.task3;
import edu.hw3.Main;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FrequencyDictionaryTest {
    @Test
    public void testEmptyList() {
        List<Object> list = List.of();
        Map<Object, Integer> expected = new HashMap<>();
        Map<Object, Integer> actual = Main.getFrequencyDictionary(list);
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleElementList() {
        List<Object> list = List.of("a");
        Map<Object, Integer> expected = new HashMap<>();
        expected.put("a", 1);
        Map<Object, Integer> actual = Main.getFrequencyDictionary(list);
        assertEquals(expected, actual);
    }

    @Test
    public void testMultipleElementList() {
        List<Object> list = Arrays.asList("a", "b", "a", "c", "b", "a");
        Map<Object, Integer> expected = new HashMap<>();
        expected.put("a", 3);
        expected.put("b", 2);
        expected.put("c", 1);
        Map<Object, Integer> actual = Main.getFrequencyDictionary(list);
        assertEquals(expected, actual);
    }
}
