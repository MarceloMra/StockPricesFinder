package com.example.StockPricesFinder.service;

import com.example.StockPricesFinder.interfaces.StockPrices;
import com.example.StockPricesFinder.interfaces.StockRepository;
import com.example.StockPricesFinder.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockService implements StockPrices {

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
        try {
            Stock searchedStock = findByStockCode(stock.getSymbol());
            setImmutableStockFieldsToKeepThemPersisted(stock, searchedStock);
        } catch (IllegalArgumentException e){
            stock.setCreationDate(new Date());
        }

        return this.stockRepository.save(stock);
    }

    @Override
    public void deleteByStockSymbol(String stockSymbol) {
        this.stockRepository.deleteBySymbol(stockSymbol);
    }

    private void setImmutableStockFieldsToKeepThemPersisted(Stock stock, Stock searchedStock) {
        stock.setCreationDate(searchedStock.getCreationDate());
    }
}
