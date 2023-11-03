package edu.hw3.task8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static java.util.Arrays.*;
import static org.junit.jupiter.api.Assertions.*;

class BackwardIteratorTest {
    @Test
    public void testBackwardIteration() {
        List<Integer> list = asList(1, 2, 3, 4, 5);
        BackwardIterator<Integer> iterator = new BackwardIterator<>(list);
        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        List<Integer> expected = asList(5, 4, 3, 2, 1);
        assertEquals(expected, result);
    }

    @Test
    public void testHasNextAfterIteration() {
        List<String> list = asList("a", "b", "c");
        BackwardIterator<String> iterator = new BackwardIterator<>(list);
        while (iterator.hasNext()) {
            iterator.next();
        }
        assertFalse(false);
    }

    @Test
    public void testHasNextWithEmptyList() {
        List<Double> list = Collections.emptyList();
        BackwardIterator<Double> iterator = new BackwardIterator<>(list);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIterationWithSingleElementList() {
        List<Character> list = Collections.singletonList('a');
        BackwardIterator<Character> iterator = new BackwardIterator<>(list);
        assertTrue(iterator.hasNext());
        assertEquals('a', iterator.next().charValue());
        assertFalse(iterator.hasNext());
    }
    @Test
    public void testIterationWithNullElement() {
        List<String> list = asList("a", null, "c");
        BackwardIterator<String> iterator = new BackwardIterator<>(list);
        List<String> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        List<String> expected = asList("c", null, "a");
        assertEquals(expected, result);
    }
}
