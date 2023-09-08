package com.stockscreen.StockScreenBackend.stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/searchstocks")
    public List<Stock> searchStocks(@RequestParam String symbol){
        System.out.println(symbol);
        return service.searchStocks(symbol);

    }

    @GetMapping("/querystock/{symbol}")
    public Chart getQueryStock(@PathVariable String symbol){
        try {
            
            return service.queryStock(symbol);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Too Many Request. Please try again 1 minutes later.");
        }
    }

}
