package com.stockscreen.StockScreenBackend.chart;

import java.beans.ConstructorProperties;

public class CandleValue {

    private double close;
    private String datetime;
    private double high;
    private double low;
    private double open;
    private long volume;

    @ConstructorProperties({"close","datetime","high","low","open","volume"})
    public CandleValue(double close,String datetime, double high, double low, double open, long volume){
        this.close = close;
        this.datetime = datetime;
        this.high = high;
        this.low = low;
        this.open = open;
        this.volume = volume;
    }

    public double getClose(){
        return close;
    }
    public String getDatetime(){
        return datetime;
    }
    public double getHigh(){
        return high;
    }
    public double getLow(){
        return low;
    }
    public double getOpen(){
        return open;
    }
    public long getVolume(){
        return volume;
    }
}
