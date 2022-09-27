package com.example.demo.exception;

public class CurrencyNotFoundException extends Exception{
    public CurrencyNotFoundException() {
        super("The currency is invalid.");
    }
}
