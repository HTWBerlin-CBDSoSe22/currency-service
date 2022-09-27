package com.example.demo.amqp;

import com.example.demo.exception.CurrencyNotFoundException;
import com.example.demo.model.CurrencyExchangeDto;
import com.example.demo.service.CurrencyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @RabbitListener(queues = "#{queue.name}")
    public String receive(CurrencyExchangeDto currencyExchangeDto) {
        String oldCurrency = currencyExchangeDto.getOldCurrency();
        String newCurrency = currencyExchangeDto.getNewCurrency();
        CurrencyService currencyService = new CurrencyService();
        try {
            String exchangeRate = currencyService.getExchangeRateSpecified(oldCurrency, newCurrency);
            return exchangeRate;
        }
        catch (CurrencyNotFoundException e) {
            e.printStackTrace();
        }
        return "invalid currency";
    }
}
