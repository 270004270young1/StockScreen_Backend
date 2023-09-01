package com.stockscreen.StockScreenBackend.stock;

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

import com.stockscreen.StockScreenBackend.chart.Chart;

@RestController
@RequestMapping("/api")
public class StockController {
    
    @Autowired
    private StockService service;

    @GetMapping("/getallstocks")
    public List<Stock> getAllStocks(){
        System.out.println("GET ALL STOCKS");
        
        return service.getAllStocks();
        
    }

    @GetMapping("/getstocksymbol")
    public String getStockSymbol(){
        //System.out.println("GET ALL STOCKS");
        
        return service.getAllStocks().get(0).getSymbol();
        
    }

    @GetMapping("/getstocks")
    public List<Stock> getstocks(){

        return service.filterStocks(service.getAllStocks());
    }

    @GetMapping("/querystock")
    public Chart getQueryStock(){

        return service.queryStock("AAPL");
    }
}
