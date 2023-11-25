package edu.hw7.task4;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;
import static org.junit.jupiter.api.Assertions.*;

class PiThreadTest {

    @Test
    public void testRandomValues() {
        PiThread piThread = new PiThread(1);
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double x = random.nextDouble();
        double y = random.nextDouble();
        piThread.run();
        assertEquals(1, PiThread.totalCount);
        if (x * x + y * y <= 1) {
            assertEquals(1, PiThread.circleCount);
        } else {
            assertEquals(0, PiThread.circleCount);
        }
    }
}
