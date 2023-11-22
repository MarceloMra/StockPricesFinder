package com.example.StockPricesFinder.repository;

import com.example.StockPricesFinder.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockRepository extends MongoRepository<Stock, String> {
    List<Stock> deleteBySymbol(String symbol);

}
