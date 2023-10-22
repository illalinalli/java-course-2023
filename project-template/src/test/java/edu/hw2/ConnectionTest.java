package edu.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
