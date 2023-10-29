package edu.hw3.task2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class СlusterizeTest {
    @Test
    public void testClusterize() {
        String input = "(abc)(def)(ghi)";
        List<String> expected = Arrays.asList("(abc)", "(def)", "(ghi)");
        List<String> actual = Сlusterize.clusterize(input);
        assertEquals(expected, actual);
    }

    @Test
    public void testClusterizeEmptyInput() {
        String input = "";
        List<String> expected = List.of();
        List<String> actual = Сlusterize.clusterize(input);
        assertEquals(expected, actual);
    }

}
