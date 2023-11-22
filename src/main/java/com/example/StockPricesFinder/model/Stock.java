package com.example.StockPricesFinder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {

    @Id
    private String id;
    private String symbol;
    private Float regularMarketPrice;
    private String shortName;
    private String longName;
    private Date lastStockPriceUpdatedDate;
    private Date creationDate;
}
