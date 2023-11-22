package com.example.StockPricesFinder.controller;

import com.example.StockPricesFinder.model.Stock;
import com.example.StockPricesFinder.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stock")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> findAllStocks(){
        return stockService.findAll();
    }

    @GetMapping("/{stockCode}")
    public Stock findStockByCode(@PathVariable String stockCode){
        return stockService.findByStockCode(stockCode);
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock){
        return stockService.saveStock(stock);
    }

    @DeleteMapping("/{stockSymbol}")
    public void deleteStock(@PathVariable String stockSymbol){
        stockService.deleteByStockSymbol(stockSymbol);
    }
}
