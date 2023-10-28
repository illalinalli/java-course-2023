package edu.hw2;

import edu.hw2.task3.Connection;
import edu.hw2.task3.ConnectionException;
import edu.hw2.task3.ConnectionManager;
import edu.hw2.task3.FaultyConnectionManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FaultyConnectionManagerTest {

    @Test
    public void testFaultyConnectionManager() throws Exception {
        ConnectionManager manager = new FaultyConnectionManager(50);
        Connection connection = manager.getConnection();
        assertThrows(ConnectionException.class, () -> connection.execute("ls"));
        connection.close();
    }
}
