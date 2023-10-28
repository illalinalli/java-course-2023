package edu.hw2;

import edu.hw2.task4.Calling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CallingTest {
    @Test
    public void testCallingInfo() {
        Calling.CallingInfo callingInfo = Calling.callingInfo();
        assertNotNull(callingInfo);
        assertEquals("edu.hw2.CallingTest", callingInfo.className());
        assertEquals("testCallingInfo", callingInfo.methodName());
    }
}
