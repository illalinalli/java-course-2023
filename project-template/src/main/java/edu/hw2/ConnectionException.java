package edu.hw2;

public class ConnectionException extends RuntimeException {
    public ConnectionException(RuntimeException connectionFailed) {
        super(connectionFailed);
    }
}
