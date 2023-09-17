package com.stockscreen.StockScreenBackend.stock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockscreen.StockScreenBackend.TooManyRequestException;
import com.stockscreen.StockScreenBackend.chart.CandleValue;
import com.stockscreen.StockScreenBackend.chart.Chart;
import com.stockscreen.StockScreenBackend.utils.RequestManager;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;


@Service
public class StockService {

   @Autowired
   private RestTemplate restTemplate;

    @Autowired
    private Environment env;

    private ObjectMapper mapper;

    public StockService(){
        mapper = new ObjectMapper();
    }


    public List<Stock> getAllStocks(){

        HttpEntity<String> httpEntity = RequestManager.getTwelveAPIHeader(env.getProperty("RAPIDAPI_KEY"));
        ResponseEntity<String> rs = restTemplate.exchange(RequestManager.getAllStocksURL_TWELVE(),HttpMethod.GET,httpEntity,String.class);

        try {
            JsonNode node = mapper.readTree(rs.getBody());
            List<Stock> stocks = mapper.readValue(node.get("data").toString(),new TypeReference<List<Stock>>(){});
            
            return stocks;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

        }

        return null;
    }

    public List<Stock> filterStocks(List<Stock> stocks){

        HttpEntity<String> httpEntity = RequestManager.getYahooAPIHeader(env.getProperty("RAPIDAPI_KEY"));

        List<Stock> filteredStocks= new ArrayList<Stock>();
        System.out.println(stocks.size());
        for(int i=0;i<stocks.size();i+=200){
            
            String stockToSend = "";
            for(int j=0;j<200;j++){

                if(i+j>=stocks.size())
                    break;
                stockToSend+=stocks.get(i+j).getSymbol()+",";
                //stockToSend.add(stocks.get(i+j));
            }
            try {
            
                ResponseEntity<String> rs = restTemplate.exchange(String.format("https://yahoo-finance15.p.rapidapi.com/api/yahoo/qu/quote/%s",stockToSend),HttpMethod.GET,httpEntity,String.class);
    
                List<Stock> tempStocks = mapper.readValue(rs.getBody(),new TypeReference<List<Stock>>(){});
                
                // for(int j=0;j<tempStocks.size();j++){
                //     filteredStocks.add(tempStocks.get((j)));
                // }
            } catch (Exception e) {
                // TODO: handle exception
                //System.out.println(e.getMessage());
            }

        }



        return filteredStocks;
    }

    public Chart queryStock(String symbol) throws TooManyRequestException,StockNotAvailableException{

        HttpEntity<String> httpEntity = RequestManager.getTwelveAPIHeader(env.getProperty("RAPIDAPI_KEY"));
        try {
        ResponseEntity<String> rs = restTemplate.exchange(RequestManager.getSymbolCandleStick_TWELVE(symbol, "1day", 180),HttpMethod.GET,httpEntity,String.class);

                       
            JsonNode node = mapper.readTree(rs.getBody());
            
            //System.out.println("Still running");
            if(node.get("values")==null)
                throw new StockNotAvailableException();
            List<CandleValue> candleValues = mapper.readValue(node.get("values").toString(),new TypeReference<List<CandleValue>>(){});
            return new Chart(candleValues);
        }
        catch(StockNotAvailableException e){
            throw e;
        }
        catch (Exception e) {
            //System.out.println(e.getMessage());
            throw new TooManyRequestException();
        }
       
        
    }


    public List<Stock> searchStocks(String symbol) throws TooManyRequestException{
        
        HttpEntity<String> httpEntity = RequestManager.getTwelveAPIHeader(env.getProperty("RAPIDAPI_KEY"));
        try {
        ResponseEntity<String> rs = restTemplate.exchange(RequestManager.searchStocks_TWELVE(symbol),HttpMethod.GET,httpEntity,String.class);

            JsonNode node = mapper.readTree(rs.getBody());
            List<Stock> stocks = mapper.readValue(node.get("data").toString(),new TypeReference<List<Stock>>(){});
            return stocks;
        } catch (Exception e) {
            // TODO: handle exception
            //System.out.println(e.getMessage());
            throw new TooManyRequestException();
           
        }
    }




    

}
