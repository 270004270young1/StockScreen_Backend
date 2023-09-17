package com.stockscreen.StockScreenBackend.stock;

public class StockNotAvailableException extends Exception{

    public StockNotAvailableException(){
        super("Stock not available. Please try other stocks.");
    }

}
