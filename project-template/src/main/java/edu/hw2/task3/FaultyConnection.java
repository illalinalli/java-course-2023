package edu.hw2.task3;

import java.util.Random;

public class FaultyConnection implements Connection {
    private final int failureRate;
    private boolean closed = false;
    private final Random random = new Random();

    public FaultyConnection(int failureRate) {
        this.failureRate = failureRate;
    }

    @Override
    public void execute(String command) {
        if (closed) {
            throw new IllegalStateException("Connection is closed");
        }
        if (random.nextInt(100) < failureRate) {
            throw new ConnectionException(new RuntimeException("Connection failed"));
        }
        // Выполнение команды при неисправном подключении
    }

    @Override
    public void close() {
        closed = true;
        // Закрываем faulty подключение
    }
}
