package com.aluracursos.currencyconverter.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {
    public String dateAndHour(){
        LocalDateTime actualDateAndHour = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-uuuu | HH:mm:ss");
        return actualDateAndHour.format(formatter);
    }
}