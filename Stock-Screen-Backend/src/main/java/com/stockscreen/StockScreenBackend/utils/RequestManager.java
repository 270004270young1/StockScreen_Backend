package com.stockscreen.StockScreenBackend.utils;


import java.net.URI;

import org.springframework.http.HttpEntity;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


public class RequestManager {
    
    public static HttpEntity<String> getTwelveAPIHeader(String key){

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("X-RapidAPI-Key",key);
        headers.add("X-RapidAPI-Host","twelve-data1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return httpEntity;
        

    }

    public static HttpEntity<String> getYahooAPIHeader(String key){

        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("X-RapidAPI-Key",key);
        headers.add("X-RapidAPI-Host","yahoo-finance15.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        return httpEntity;
        

    } 

    public static String getAllStocksURL_TWELVE(){
        return "https://twelve-data1.p.rapidapi.com/stocks?exchange=NASDAQ&format=json";
    }

    public static String getSymbolCandleStick_TWELVE(String symbol,String interval, int outputSize){
        return String.format("https://twelve-data1.p.rapidapi.com/time_series?symbol=%s&interval=%s&outputsize=%s&format=json",symbol,interval,outputSize);
    }

    public static String searchStocks_TWELVE(String symbol) {
        return String.format("https://twelve-data1.p.rapidapi.com/symbol_search?symbol=%s&outputsize=5",symbol);
    }

}
