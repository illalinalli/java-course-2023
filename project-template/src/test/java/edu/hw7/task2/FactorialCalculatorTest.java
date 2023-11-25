package edu.hw7.task2;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class FactorialCalculatorTest {
    @Test
    public void testFactorialForZero() {
        FactorialCalculator fc = new FactorialCalculator();
        assertEquals(BigInteger.ONE, fc.factorial(0));
    }

    @Test
    public void testFactorialForOne() {
        FactorialCalculator fc = new FactorialCalculator();
        assertEquals(BigInteger.ONE, fc.factorial(1));
    }

    @Test
    public void testFactorialForSmallPositiveNumber() {
        FactorialCalculator fc = new FactorialCalculator();
        assertEquals(new BigInteger("120"), fc.factorial(5));
    }

    @Test
    public void testFactorialForLargePositiveNumber() {
        FactorialCalculator fc = new FactorialCalculator();
        assertEquals(new BigInteger("30414093201713378043612608166064768844377641568960512000000000000"), fc.factorial(50));
    }
}
