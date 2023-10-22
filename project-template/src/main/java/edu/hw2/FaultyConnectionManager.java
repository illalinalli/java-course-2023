package edu.hw2;

public class FaultyConnectionManager implements ConnectionManager {
    private final int failureRate;

    public FaultyConnectionManager(int failureRate) {
        this.failureRate = failureRate;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(failureRate);
    }
}
