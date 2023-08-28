package com.stockscreen.StockScreenBackend.getStockInfo.JSONmodels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock{

    private String symbol;
    @JsonCreator
    public Stock(@JsonProperty("symbol") String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}