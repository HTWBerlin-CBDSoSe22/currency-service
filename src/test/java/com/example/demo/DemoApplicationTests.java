package com.example.demo;

import com.example.demo.exception.CurrencyNotFoundException;
import com.example.demo.service.CurrencyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void eurToSekTest() throws CurrencyNotFoundException {
		// mocking api
		CurrencyService currencyServiceMock = Mockito.mock(CurrencyService.class);
		when(currencyServiceMock.getExchangeRateSpecified("EUR", "SEK")).thenReturn("10.776027");

		String eurToSek = currencyServiceMock.getExchangeRateSpecified("EUR", "SEK");
		assertEquals("10.776027", eurToSek);
	}

	@Test
	void usdToEurTest() throws CurrencyNotFoundException {
		CurrencyService currencyServiceMock = Mockito.mock(CurrencyService.class);
		when(currencyServiceMock.getExchangeRateSpecified("USD", "EUR")).thenReturn("0.998373");

		String usdToEur = currencyServiceMock.getExchangeRateSpecified("USD", "EUR");
		assertEquals("0.998373", usdToEur);
	}

	@Test
	void sekToUsdTest() throws CurrencyNotFoundException {
		CurrencyService currencyServiceMock = Mockito.mock(CurrencyService.class);
		when(currencyServiceMock.getExchangeRateSpecified("SEK", "USD")).thenReturn("0.09295");

		String sekToUsd = currencyServiceMock.getExchangeRateSpecified("SEK", "USD");
		assertEquals("0.09295", sekToUsd);
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
