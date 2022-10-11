package com.example.StockPricesFinder.service;

import com.example.StockPricesFinder.interfaces.StockPrices;
import com.example.StockPricesFinder.interfaces.StockRepository;
import com.example.StockPricesFinder.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockPricesService implements StockPrices {

    @Autowired
    private StockRepository stockRepository;


    @Override
    public List<Stock> findAll() {
        return this.stockRepository.findAll();
    }

    @Override
    public Stock findByStockCode(String stockCode) {
        return this.stockRepository
                .findById(stockCode)
                .orElseThrow(() -> new IllegalArgumentException("Stock ${stockCode} not found!"));
    }

    @Override
    public Stock saveStock(Stock stock) {
        return this.stockRepository.save(stock);
    }

    @Override
    public void deleteByStockCode(String stockCode) {
        this.stockRepository.deleteById(stockCode);
    }
}
