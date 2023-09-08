package com.stockscreen.StockScreenBackend;
public class TooManyRequestException extends Exception{
    

    public TooManyRequestException(String message){
        super(message);
    }

    public TooManyRequestException(){
        super("Too many requests. Please try later on.");
    }

}
