package com.example.demo;

import com.example.demo.exception.CurrencyNotFoundException;
import com.example.demo.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void eurToSekTest() throws CurrencyNotFoundException {
		// mock api...
		CurrencyService cs =  new CurrencyService();
		String eurToSek = cs.getExchangeRateSpecified("EUR", "SEK");
		assertEquals("10.688494", eurToSek);
	}

	@Test
	void usdToEurTest() throws CurrencyNotFoundException {
		// mock api...
		CurrencyService cs =  new CurrencyService();
		String usdToEur = cs.getExchangeRateSpecified("USD", "EUR");
		assertEquals("0.996001", usdToEur);
	}

	@Test
	void sekToUsdTest() throws CurrencyNotFoundException {
		// mock api...
		CurrencyService cs =  new CurrencyService();
		String sekToUsd = cs.getExchangeRateSpecified("SEK", "USD");
		assertEquals("0.093934", sekToUsd);
	}

	@Test
	void invalidCurrencyToSekTest() {
		CurrencyService cs =  new CurrencyService();
		assertThrows(CurrencyNotFoundException.class, () -> cs.getExchangeRateSpecified("EURR", "SEK"));
	}

	@Test
	void eurToInvalidCurrencyTest() {
		CurrencyService cs =  new CurrencyService();
		assertThrows(CurrencyNotFoundException.class, () -> cs.getExchangeRateSpecified("EUR", "SEKK7"));
	}

	@Test
	void invalidCurrencyToInvalidCurrencyTest() {
		CurrencyService cs =  new CurrencyService();
		assertThrows(CurrencyNotFoundException.class, () -> cs.getExchangeRateSpecified("EURR12r", "SEKK7"));
	}
}
