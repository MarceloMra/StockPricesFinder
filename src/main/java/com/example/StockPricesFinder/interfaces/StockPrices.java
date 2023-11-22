package com.example.StockPricesFinder.interfaces;

import com.example.StockPricesFinder.model.Stock;

import java.util.List;

public interface StockPrices {
    public List<Stock> findAll();
    public Stock findByStockCode(String stockCode);
    public Stock saveStock(Stock stock);
    public void deleteByStockSymbol(String stockSymbol);
}
