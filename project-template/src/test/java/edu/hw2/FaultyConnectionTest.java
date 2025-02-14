package edu.hw2;

import edu.hw2.task3.Connection;
import edu.hw2.task3.FaultyConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FaultyConnectionTest {

    @Test
    public void testFaultyConnection() {
        Connection connection = new FaultyConnection(50);
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalStateException.class, () -> connection.execute("ls"));
    }
}
