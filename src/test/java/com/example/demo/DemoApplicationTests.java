package com.example.demo;

import com.example.demo.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void currencyExchangeTest() {
		CurrencyService cs =  new CurrencyService();
		String eurToSek = cs.getExchangeRateSpecified("EUR", "SEK");
		assertEquals("10.598097", eurToSek);
	}
}
