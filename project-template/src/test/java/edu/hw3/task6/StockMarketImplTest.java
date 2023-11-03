package edu.hw3.task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class StockMarketImplTest {
    @Test
    public void testAdd() {
        StockMarketImpl stockMarket = new StockMarketImpl();
        Stock stock = new Stock("AAPL", 150.0);
        stockMarket.add(stock);
        assertEquals(stock, stockMarket.mostValuableStock());
    }

    @Test
    public void testRemove() {
        StockMarketImpl stockMarket = new StockMarketImpl();
        Stock stock = new Stock("AAPL", 150.0);
        stockMarket.add(stock);
        stockMarket.remove(stock);
        assertNull(stockMarket.mostValuableStock());
    }

    @Test
    public void testMostValuableStock() {
        StockMarketImpl stockMarket = new StockMarketImpl();
        Stock stock1 = new Stock("AAPL", 150.0);
        Stock stock2 = new Stock("GOOG", 200.0);
        stockMarket.add(stock1);
        stockMarket.add(stock2);
        assertEquals(stock2, stockMarket.mostValuableStock());
    }
}
