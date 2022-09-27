package com.example.demo.service;

import com.example.demo.exception.CurrencyNotFoundException;
import com.example.demo.model.Currency;
import org.springframework.web.client.RestTemplate;

public class CurrencyService {
    private final String ACCESS_KEY = "SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB";

    public String getExchangeRateSpecified(String oldCurrency, String newCurrency) throws CurrencyNotFoundException {
        if(!Currency.currencyExist(oldCurrency) || !Currency.currencyExist(newCurrency)) {
            throw new CurrencyNotFoundException();
        }

        String uri = "https://api.exchangerate.host/latest?access_key=" + ACCESS_KEY + "&base=" + oldCurrency + "&symbols=" + newCurrency;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        String[] splittedResult = result.split("rates\":\\{\"" + newCurrency + "\":");
        String rate = splittedResult[1].substring(0, (splittedResult[1].length() - 2));

        return rate;
    }
}
