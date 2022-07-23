package com.example.demo.controller;

import com.example.demo.model.Rates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
public class CurrencyController {

    private final String API_KEY = "SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB";

    @GetMapping("/currency")
    String getCurrency(){
        return "Hello Currency";
    }

    @GetMapping("https://api.apilayer.com/exchangerates_data/latest")
    String getInfo() {
        return "hello info";
    }

    @GetMapping("https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}")
    String getResponse(@RequestHeader(name = "apikey", value = API_KEY) String s, @PathVariable String amount, @PathVariable String from, @PathVariable String to) {
    return "hello";
//    HttpClie client = new HttpClient.Builder().build();
//
//    Request request = new Request.Builder()
//            .url("https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}")
//            .addHeader("apikey", "{API-KEY}")
//            .method("GET", })
//            .build();
//        Response response = client.newCall(request).execute();
//        System.out.println(response.body().string());

    }

    @GetMapping("/countries")
    String getCountries() {
        String uri = "https://restcountries.com/v3.1/all\n";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/exchangeRateLatest")
    String getExchangeRateLatest() {
        String uri = "https://api.exchangerate.host/latest";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping("/exchangeRateSpecified")
    String getExchangeRateSpecified() {
        String uri = "https://api.exchangerate.host/latest?access_key=SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB&base=USD&symbols=GBP,JPY,USD";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        return result;
    }

//    @GetMapping("/exchangeRateResponseBody")
//    @ResponseBody
//    String getExchangeRateResponseBody() {
//        String uri = "https://api.exchangerate.host/latest?access_key=SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB&base=USD&symbols=GBP,JPY,USD";
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);
//        ResponseEntity<String> re = new ResponseEntity<String>(result, HttpStatus.MULTI_STATUS);
//        return re.getHeaders().getFirst("*");
//    }

    @GetMapping("/exchangeRateResponseBody")
    @ResponseBody
    String getExchangeRateResponseBody() {
        String uri = "https://api.exchangerate.host/latest?access_key=SGZliVw2kVfH3lXpOjLvJyXzp5b1iqdB&base=USD&symbols=GBP,JPY,USD";
        RestTemplate restTemplate = new RestTemplate();
        Rates result = restTemplate.getForObject(uri, Rates.class);
//        ResponseEntity<String> re = new ResponseEntity<String>(result, HttpStatus.MULTI_STATUS);
        return result.getRates();
    }
}
