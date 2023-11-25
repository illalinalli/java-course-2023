package edu.hw7.task4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PiApproximator {
    public static void main(String[] args) throws InterruptedException {
        // однопоточная версия
        long start = System.currentTimeMillis();
        int N = 100000000;
        int totalCount = 0;
        int circleCount = 0;
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            double x = random.nextDouble();
            double y = random.nextDouble();
            if (x * x + y * y <= 1) {
                circleCount++;
            }
            totalCount++;
        }
        double piApproximation = 4.0 * (double) circleCount / (double) totalCount;
        long end = System.currentTimeMillis();
        System.out.println("Число Пи: " + piApproximation);
        System.out.println("Затраченное время: " + (end - start) / 1000.0 + " сек.");

        // многопоточная версия
        start = System.currentTimeMillis();
        N = 100000000;
        int threadsCount = Runtime.getRuntime().availableProcessors();
        PiThread[] threads = new PiThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            threads[i] = new PiThread(N / threadsCount);
            threads[i].start();
        }
        for (int i = 0; i < threadsCount; i++) {
            threads[i].join();
        }
        piApproximation = 4.0 * (double) circleCount / (double) totalCount;
        end = System.currentTimeMillis();
        System.out.println("Число Пи: " + piApproximation);
        System.out.println("Затраченное время: " + (end - start) / 1000.0 + " сек. ");
    }
}
