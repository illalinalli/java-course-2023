package edu.hw7.task2;
import java.math.BigInteger;

public class FactorialCalculator {
    public BigInteger factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Number must be non-negative.");
        }

        if (num == 0 || num == 1) {
            return BigInteger.ONE;
        }

        return computeFactorial(num);
    }

    private BigInteger computeFactorial(int num) {
        return java.util.stream.IntStream.rangeClosed(2, num)
            .parallel()
            .mapToObj(BigInteger::valueOf)
            .reduce(BigInteger.ONE, BigInteger::multiply);
    }
}
