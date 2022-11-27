package com.dark.webshop.exception_handling;

public class EntryAlreadyExistException extends RuntimeException {
    public EntryAlreadyExistException(String message) {
        super(message);
    }
}
