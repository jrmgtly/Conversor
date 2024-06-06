package com.aluracursos.currencyconverter.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EnvLoader {
    private static void loadEnv() {
        String filePath= "resources/.env";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);
                if (parts.length == 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    System.setProperty(key, value);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String returnAPIKey(){
        loadEnv();
        return System.getProperty("API_KEY");
    }
}