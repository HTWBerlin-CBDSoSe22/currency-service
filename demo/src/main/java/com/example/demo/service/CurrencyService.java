package com.example.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class CurrencyService {

    public String getExchangeRateSpecified(String oldCurrency, String newCurrency) {
        String uri = "https://api.exchangerate.host/latest?access_key=SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB&base=" + oldCurrency + "&symbols=" + newCurrency;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        String[] splittedResult = result.split("rates\":\\{\"" + newCurrency + "\":");
        String rate = splittedResult[1].substring(0, (splittedResult[1].length() - 2));

        // testing with factor...
//        double rate = Double.parseDouble(splittedResult[1].substring(0, (splittedResult[1].length() - 2)));
//        double factor1 = 100;
//        double factor2 = 0.5;
//        System.out.println("result: " + rate + "; * 100 = " + (rate * factor1) + "; * 0.5 = " + (rate * factor2) + " ... " + result);
//        return result;
        System.out.println("rate from " + oldCurrency + " to " + newCurrency + ": " + rate + " " + newCurrency);
        return rate;
    }
}
