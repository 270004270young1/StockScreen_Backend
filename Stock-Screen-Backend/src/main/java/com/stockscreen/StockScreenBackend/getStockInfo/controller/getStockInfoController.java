package com.stockscreen.StockScreenBackend.getStockInfo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockscreen.StockScreenBackend.getStockInfo.JSONmodels.Stock;
import com.stockscreen.StockScreenBackend.getStockInfo.JSONmodels.StockWrapper;
import com.stockscreen.StockScreenBackend.getStockInfo.service.getStockInfoService;

@RestController
@RequestMapping("/api")
public class getStockInfoController {
    
    @Autowired
    private getStockInfoService service;

    @GetMapping("/getallstocks")
    public String getAllStocks(){
        System.out.println("GET ALL STOCKS");
        // List<String> rs = new ArrayList<String>();
        // for(StockWrapper sw:service.getAllStocks()){
            //     rs.add(sw.getSymbol());
            // }
        service.getAllStocks();
        return "HEllo";
    }
}
