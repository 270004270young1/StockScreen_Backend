package com.stockscreen.StockScreenBackend.getStockInfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stockscreen.StockScreenBackend.getStockInfo.service.getStockInfoService;

@RestController
@RequestMapping("/api")
public class getStockInfoController {
    
    @Autowired
    private getStockInfoService service;

    @GetMapping("/hello")
    public String sayHello(){
        return service.get();
    }
}
