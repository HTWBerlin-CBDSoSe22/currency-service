package com.example.demo;

import com.example.demo.service.CurrencyService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello 1");
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hello 2");
		CurrencyService cs =  new CurrencyService();
		cs.getExchangeRateSpecified("EUR", "SEK");
	}

}
