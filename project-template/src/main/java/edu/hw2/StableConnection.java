package edu.hw2;

public class StableConnection implements Connection {
    private boolean closed = false;

    @Override
    public void execute(String command) {
        if (closed) {
            throw new IllegalStateException("Connection is closed");
        }
    }

    @Override
    public void close() {
        closed = true;
    }
}
