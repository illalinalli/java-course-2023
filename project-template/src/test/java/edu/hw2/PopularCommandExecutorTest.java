package edu.hw2;

import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import edu.hw2.task3.PopularCommandExecutor;
import org.junit.jupiter.api.Test;

class PopularCommandExecutorTest {

    @Test
    public void testPopularCommandExecutor() {
        ConnectionManager manager = new DefaultConnectionManager(50);
        PopularCommandExecutor executor = new PopularCommandExecutor(manager, 3);
        executor.updatePackages();
    }
}
