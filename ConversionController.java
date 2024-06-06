package com.aluracursos.currencyconverter.api;

import com.aluracursos.currencyconverter.models.Conversion;

import java.util.Map;

public class ConversionController {
    private final Map<String, Double> exchangeRates;

    public ConversionController(Map<String, Double> exchangeRates) {
        if (exchangeRates==null){
            throw new NullPointerException("Can't initialize Conversion Controller: Exchange rate map is null");
        }
        this.exchangeRates = exchangeRates;
    }

    public double convert(Conversion conversion) {
        String fromCurrency= conversion.getFromCurrency().toUpperCase();
        String toCurrency= conversion.getToCurrency().toUpperCase();
        Double amount= conversion.getAmountToConvert();
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Currency code not found");
        }

        double amountInUSD = amount / exchangeRates.get(fromCurrency);

        return amountInUSD * exchangeRates.get(toCurrency);
    }
}
