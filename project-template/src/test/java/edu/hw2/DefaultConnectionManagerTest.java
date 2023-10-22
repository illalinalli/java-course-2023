package edu.hw2;

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
