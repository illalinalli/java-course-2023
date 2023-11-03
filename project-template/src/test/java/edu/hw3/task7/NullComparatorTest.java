package edu.hw3.task7;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class NullComparatorTest {

    @Test
    void compare() {
        TreeMap<String, String> tree = new TreeMap<>(new NullComparator<>());
        tree.put(null, "test");
        assertTrue(tree.containsKey(null));
    }

    @Test
    public void testCompareBothNull() {
        NullComparator<Object> comparator = new NullComparator<>();
        int result = comparator.compare(null, null);
        assertEquals(0, result);
    }

    @Test
    public void testCompareOneNull() {
        NullComparator<String> comparator = new NullComparator<>();
        int result = comparator.compare(null, "test");
        assertEquals(-1, result);
    }

    @Test
    public void testCompareEqualObjects() {
        NullComparator<String> comparator = new NullComparator<>();
        int result = comparator.compare("test", "test");
        assertEquals(0, result);
    }

}
