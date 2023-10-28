package edu.hw2;

import edu.hw2.task3.Connection;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.DefaultConnectionManager;
import org.junit.jupiter.api.Test;

class DefaultConnectionManagerTest {
    @Test
    public void testDefaultConnectionManager() throws Exception {
        ConnectionManager manager = new DefaultConnectionManager(50);
        Connection connection = manager.getConnection();
        connection.execute("ls");
        connection.close();
    }

}
