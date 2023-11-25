package edu.hw7.task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CounterTest {
    @Test
    public void testCounter() throws InterruptedException {
        Counter counter = new Counter();
        int numOfThreads = 10;
        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (int i = 0; i < numOfThreads; i++) {
            threads[i].join();
        }

        Assertions.assertEquals(100000, counter.getCount());
    }
}
