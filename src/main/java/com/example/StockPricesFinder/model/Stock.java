package com.example.StockPricesFinder.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Stock {

    @Id
    private String stockCode;
    private Float stockPrice;
    private Date lastStockPriceUpdateTime;
}
