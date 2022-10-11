package com.example.StockPricesFinder.interfaces;

import com.example.StockPricesFinder.model.Stock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StockRepository extends MongoRepository<Stock, String> {
}
