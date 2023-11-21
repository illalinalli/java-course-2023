package edu.hw6.task1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;

class DiskMapTest {
    private static final String TEST_FILE_PATH = "myDiskMap.txt";

    @Test
    public void testPutAndGet() {
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        assertEquals("value1", diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    public void testRemove() {
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        assertEquals("value1", diskMap.remove("key1"));
        assertNull(diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    public void testSizeAndIsEmpty() {
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        assertTrue(diskMap.isEmpty());
        diskMap.put("key1", "value1");
        assertFalse(diskMap.isEmpty());
        diskMap.put("key2", "value2");
        assertEquals(2, diskMap.size());
    }

    @Test
    public void testContainsKeyAndContainsValue() {
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        assertTrue(diskMap.containsKey("key1"));
        assertFalse(diskMap.containsKey("key3"));
        assertTrue(diskMap.containsValue("value2"));
        assertFalse(diskMap.containsValue("value3"));
    }

    @Test
    public void testClear() {
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.clear();
        assertTrue(diskMap.isEmpty());
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                fail("The test file should be empty");
            }
        } catch (Exception e) {
            fail("Failed to read the test file");
        }
    }

    @Test
    public void testPutAll(){
        Map<String, String> toAdd = Map.of("key1", "value1", "key2", "value2");
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        diskMap.putAll(toAdd);
        assertTrue(diskMap.containsKey("key1"));
        assertTrue(diskMap.containsKey("key2"));
    }

    @Test
    public void testEntrySet() {
        DiskMap diskMap = new DiskMap(TEST_FILE_PATH);
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        for (Map.Entry<String, String> entry : diskMap.entrySet()) {
            assertTrue(diskMap.containsKey(entry.getKey()));
            assertTrue(diskMap.containsValue(entry.getValue()));
        }
    }
}
