package edu.hw3.task6;

import java.util.Comparator;
import java.util.PriorityQueue;

public class StockMarketImpl implements StockMarket {
    private final PriorityQueue<Stock> stocks;
    public StockMarketImpl() {
        stocks = new PriorityQueue<>(Comparator.comparingDouble(Stock::getPrice));
    }

    @Override
    public void add(Stock stock) {
        stocks.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stocks.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stocks.peek();
    }
}
