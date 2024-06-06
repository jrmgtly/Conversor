package com.aluracursos.currencyconverter.api;

import com.aluracursos.currencyconverter.models.CurrencyDTO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

import static com.aluracursos.currencyconverter.util.EnvLoader.returnAPIKey;

public class CurrencyService {

    String API_KEY=returnAPIKey();
    String baseURL= "https://v6.exchangerate-api.com/v6/";

    public Map<String,Double> getCurrency(String currencyCode){
        String URL= baseURL+API_KEY+"/latest/"+currencyCode;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            CurrencyDTO conversionRatesObject= new Gson().fromJson(json, CurrencyDTO.class);
            String conversionRatesJson= new Gson().toJson(conversionRatesObject.conversion_rates());
            Map<String, Double> conversionRatesMap;
            conversionRatesMap = jsonToMap(conversionRatesJson);
            return conversionRatesMap;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Double> jsonToMap(String json) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Double>>(){}.getType();
        return gson.fromJson(json, type);
    }
}
