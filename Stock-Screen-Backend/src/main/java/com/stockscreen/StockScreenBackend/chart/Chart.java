package com.stockscreen.StockScreenBackend.chart;

import java.beans.ConstructorProperties;
import java.util.List;

public class Chart {
    
    private List<CandleValue> candleSticks;
    
    @ConstructorProperties({"values"})
    public Chart(List<CandleValue> candleSticks){
        this.candleSticks = candleSticks;
    }

    public List<CandleValue> getCandleSticks(){
        return candleSticks;
    }

}
