package com.aluracursos.currencyconverter.util;

public class Strings {
    public static String menuString (){
        return """
                ****************************************************************
                
                *** Currency Converter ***
                
                Here is a list of all currencies supported by this program:
                https://www.exchangerate-api.com/docs/supported-currencies
                
                Or here are some examples of the currencies available:
                
                Currency          Code
                
                US Dollar         [USD]
                Euro              [EUR]
                Mexican Peso      [MXN]
                Brazilian Real    [BRL]
                Argentine Peso    [ARS]
                Colombian Peso    [COP]
                Chilean Peso      [CLP]
                Bolivian Peso     [BOB]
                
                """;
    }

    public static String optionString (){
        return """
                ****************************************************************
                
                 Type one of the following options:
                
                 1. Perform new conversion.
                 2. Generate conversion history.
                 0. End program.
                
                """;
    }
}
