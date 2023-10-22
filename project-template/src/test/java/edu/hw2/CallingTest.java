package edu.hw2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CallingTest {
    @Test
    public void testCallingInfo() {
        Calling.CallingInfo callingInfo = Calling.callingInfo();
        assertNotNull(callingInfo);
        assertEquals("edu.hw2.CallingTest", callingInfo.className());
        assertEquals("testCallingInfo", callingInfo.methodName());
    }
}
