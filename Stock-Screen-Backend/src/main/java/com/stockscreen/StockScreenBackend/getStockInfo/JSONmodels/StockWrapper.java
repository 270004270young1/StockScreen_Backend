package com.stockscreen.StockScreenBackend.getStockInfo.JSONmodels;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StockWrapper {
    private List<?> data;

    @JsonCreator
    public StockWrapper(@JsonProperty("data") List<?> data){
        this.data=data;
        
    }

    public List<?> getData(){
        return data;
    }
    
}


