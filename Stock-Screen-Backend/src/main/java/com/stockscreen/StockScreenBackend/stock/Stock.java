package com.stockscreen.StockScreenBackend.stock;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock{

    private String symbol;
    private float sma50;
   @ConstructorProperties({"symbol","sma50"})
    public Stock(String symbol,@JsonProperty("fiftyDayAverage") float sma50){
        this.symbol = symbol;
        this.sma50 = sma50;
    }

    public String getSymbol(){
        return symbol;
    }

    public float getSMA50(){
        return sma50;
    }

   
}