package com.aluracursos.currencyconverter.models;

import java.util.Scanner;

public class Conversion {
    public String fromCurrency;
    public String toCurrency;
    public Double amountToConvert;
    public Double amountConverted;
    public String dateAndHour;

    public Conversion(String fromCurrency, String toCurrency, Double amountToConvert){
        this.fromCurrency=fromCurrency;
        this.toCurrency=toCurrency;
        this.amountToConvert=amountToConvert;
    }

    public static Conversion reader (){
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the source currency code:");
        String fromCurrency= reader.next();
        System.out.println("Enter the target currency code:");
        String toCurrency= reader.next();
        System.out.println("Enter the amount to be converted:");
        String amount= reader.next();

        double doubleAmount;
        try{
            doubleAmount=Double.parseDouble(amount);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("Can't operate amount value: Please use a valid input");
        }

        return new Conversion(fromCurrency,toCurrency,doubleAmount);
    }

    @Override
    public String toString() {
        return "( Conversion made at: " + dateAndHour +
                ", from: " + fromCurrency +
                " to: " + toCurrency +
                " , "+ amountToConvert +" " + fromCurrency+ " equals to "+
                amountConverted + " " + toCurrency+ " )" + "\n";
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public Double getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountConverted(Double amountConverted) {
        this.amountConverted = amountConverted;
    }

    public void setDateAndHour(String dateAndHour) {
        this.dateAndHour = dateAndHour;
    }
}
