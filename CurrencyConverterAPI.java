package com.aluracursos.currencyconverter.currency;

import com.aluracursos.currencyconverter.api.ConversionController;
import com.aluracursos.currencyconverter.api.CurrencyService;
import com.aluracursos.currencyconverter.processor.Processor;

import java.util.Map;

public class CurrencyConverterAPI {
    public static void main(String[] args) {
        CurrencyService query = new CurrencyService();
        ConversionController converter = null;

        try {
            Map<String, Double> currency = query.getCurrency("USD");
            converter = new ConversionController(currency);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        Processor processor= new Processor();
        try {
            processor.process(converter);
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

    }

}
