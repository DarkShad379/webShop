package com.dark.webshop.exception_handling;

public class NoSuchEntryInDatabase extends RuntimeException {
    public NoSuchEntryInDatabase(String message) {
        super(message);
    }
}
