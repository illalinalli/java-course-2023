package edu.hw2;

import edu.hw2.task3.Connection;
import edu.hw2.task3.StableConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConnectionTest {

    @Test
    public void testStableConnection() {
        Connection connection = new StableConnection();
        connection.execute("ls");
        try {
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertThrows(IllegalStateException.class, () -> connection.execute("ls"));
    }


}
