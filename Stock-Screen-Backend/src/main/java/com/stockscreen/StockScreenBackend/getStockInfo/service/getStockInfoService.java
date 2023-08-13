package com.stockscreen.StockScreenBackend.getStockInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class getStockInfoService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env;

    public String get(){

    

        String rs = restTemplate.getForObject(String.format("https://api.polygon.io/v1/open-close/AAPL/2023-01-09?adjusted=true&apiKey=%s",env.getProperty("POLYGON_QUERY_KEY")),String.class);

        return rs;
    }

}
