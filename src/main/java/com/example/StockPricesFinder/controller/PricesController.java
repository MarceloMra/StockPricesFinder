package com.example.StockPricesFinder.controller;

import com.example.StockPricesFinder.model.Stock;
import com.example.StockPricesFinder.service.StockPricesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Prices")
public class PricesController {

    @Autowired
    private StockPricesService stockPricesService;

    @GetMapping
    public List<Stock> findAllStocks(){
        return stockPricesService.findAll();
    }

    @GetMapping("/{stockCode}")
    public Stock findStockByCode(@PathVariable String stockCode){
        return stockPricesService.findByStockCode(stockCode);
    }

    @PostMapping
    public Stock createStock(@RequestBody Stock stock){
        return stockPricesService.saveStock(stock);
    }

    @DeleteMapping("/{stockCode}")
    public void deleteStock(@PathVariable String stockCode){
        stockPricesService.deleteByStockCode(stockCode);
    }
}
