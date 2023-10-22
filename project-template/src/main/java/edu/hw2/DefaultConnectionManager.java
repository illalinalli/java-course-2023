package edu.hw2;

import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private final int failureRate;
    private final Random random = new Random();

    public DefaultConnectionManager(int failureRate) {
        this.failureRate = failureRate;
    }

    @Override
    public Connection getConnection() {
        if (random.nextInt(100) < failureRate) {
            return new FaultyConnection(failureRate);
        } else {
            return new StableConnection();
        }
    }
}
