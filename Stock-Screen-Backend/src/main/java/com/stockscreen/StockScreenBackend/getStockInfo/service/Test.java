package com.stockscreen.StockScreenBackend.getStockInfo.service;

import java.beans.ConstructorProperties;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Test {

    private String symbol;
    private String name;
    private String currency;
    private String exchange;
    private String mic_code;
    private String country;
    private String type;


    @ConstructorProperties({"symbol","name","currency","exchange","mic_code","country","type"})
    public Test(String symbol,String name,String currency,String exchange,String mic_code,String country,String type){
        this.symbol = symbol;
        this.name = name;
        this.currency = currency;
        this.exchange = exchange;
        this.mic_code = mic_code;
        this.country = country;
        this.type = type;
    }

    public String getSymbol(){
        return symbol;
    }

    public String getName(){
        return name;
    }
    public String getCurrency(){
        return currency;
    }
    public String getExchange(){
        return exchange;
    }
    public String getMic_code(){
        return mic_code;
    }
    public String getCountry(){
        return country;
    }
    public String getType(){
        return type;
    }
}


