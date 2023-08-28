package com.stockscreen.StockScreenBackend.getStockInfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stockscreen.StockScreenBackend.getStockInfo.JSONmodels.Stock;
import com.stockscreen.StockScreenBackend.getStockInfo.JSONmodels.StockWrapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;


@Service
public class getStockInfoService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private Environment env;


    public StockWrapper getAllStocks(){

        

        //String rs = restTemplate.getForObject(String.format("https://api.polygon.io/v1/open-close/AAPL/2023-01-09?adjusted=true&apiKey=%s",env.getProperty("POLYGON_QUERY_KEY")),String.class);

        // HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String,String> headers = new LinkedMultiValueMap<>();
        headers.add("X-RapidAPI-Key","51c5e43a0emsh44083b51743c363p1eef38jsn051b5a3beeb3");
        headers.add("X-RapidAPI-Host","twelve-data1.p.rapidapi.com");
        HttpEntity<String> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<String> rs = restTemplate.exchange("https://twelve-data1.p.rapidapi.com/stocks?exchange=NASDAQ&format=json",HttpMethod.GET,httpEntity,String.class);
        // String json = rs.getBody();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(rs.getBody());
            // StockWrapper map = mapper.readValue(rs.getBody(),StockWrapper.class); 
            // mapper.readValue 
            //Stock stock = (Stock) map.getData().get(0);
            List<Test> t = mapper.readValue(node.get("data").toString(),new TypeReference<List<Test>>(){});
            System.out.println(t.get(0).getSymbol());
            
            return null;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());

        }


        return null;
    }

}
