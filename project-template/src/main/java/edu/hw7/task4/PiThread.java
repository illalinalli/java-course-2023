package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;

public class PiThread extends Thread {

    private final int iterationsCount;
    public static int circleCount = 0;
    public static int totalCount = 0;
    public PiThread(int iterationsCount) {
        this.iterationsCount = iterationsCount;
    }

    @Override
    public void run() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int localCircleCount = 0;
        for (int i = 0; i < iterationsCount; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                localCircleCount++;
            }
            synchronized (PiApproximator.class) {
                totalCount++;
                circleCount += localCircleCount;
            }
        }
    }
}
