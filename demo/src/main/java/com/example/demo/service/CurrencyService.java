package com.example.demo.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class CurrencyService {

    public String getExchangeRateSpecified(String oldCurrency, String newCurrency) {
        String uri = "https://api.exchangerate.host/latest?access_key=SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB&base=" + oldCurrency + "&symbols=" + newCurrency;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println("result: " + result);
        return result;
    }
}
