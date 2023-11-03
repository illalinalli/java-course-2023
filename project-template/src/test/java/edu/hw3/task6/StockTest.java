package edu.hw3.task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StockTest {
    @Test
    public void testGetName() {
        Stock stock = new Stock("AAPL", 150.0);
        assertEquals("AAPL", stock.getName());
    }

    @Test
    public void testGetPrice() {
        Stock stock = new Stock("AAPL", 150.0);
        assertEquals(150.0, stock.getPrice(), 0.0);
    }

    @Test
    public void testSetPrice() {
        Stock stock = new Stock("AAPL", 150.0);
        stock.setPrice(160.0);
        assertEquals(160.0, stock.getPrice(), 0.0);
    }
}
