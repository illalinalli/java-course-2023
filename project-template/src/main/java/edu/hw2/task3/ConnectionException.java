package edu.hw2.task3;

public class ConnectionException extends RuntimeException {
    public ConnectionException(RuntimeException connectionFailed) {
        super(connectionFailed);
    }
}
