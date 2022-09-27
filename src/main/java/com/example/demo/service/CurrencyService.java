package com.example.demo.service;

import com.example.demo.exception.CurrencyNotFoundException;
import com.example.demo.model.Currency;
import org.springframework.web.client.RestTemplate;

public class CurrencyService {
//    private final String API_KEY = "9VBbjmAQznWLbQYLaG8bzuO6QLG58kVc";
    private final String ACCESS_KEY = "SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB";

    public String getExchangeRateSpecified(String oldCurrency, String newCurrency) throws CurrencyNotFoundException {
        if(!Currency.currencyExist(oldCurrency) || !Currency.currencyExist(newCurrency)) {
            throw new CurrencyNotFoundException();
        }
        // use this ALTERNATIVE exchange rate api if the server of the other on is down !!!
//        String uri = "https://api.apilayer.com/exchangerates_data/latest?apikey=" + API_KEY + "&base=" + oldCurrency + "&symbols=" + newCurrency;
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        String[] splittedResult = result.split(newCurrency + "\": ");
//        String[] splittedResult2 = splittedResult[1].split("}");
//        String rate = splittedResult2[0].substring(0, (splittedResult2[0].length() - 5));

        String uri = "https://api.exchangerate.host/latest?access_key=" + ACCESS_KEY + "&base=" + oldCurrency + "&symbols=" + newCurrency;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        String[] splittedResult = result.split("rates\":\\{\"" + newCurrency + "\":");
        String rate = splittedResult[1].substring(0, (splittedResult[1].length() - 2));

        return rate;
    }
}
