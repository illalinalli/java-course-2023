package edu.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PopularCommandExecutorTest {

    @Test
    public void testPopularCommandExecutor() {
        ConnectionManager manager = new DefaultConnectionManager(50);
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
        executor.updatePackages();
    }
}
