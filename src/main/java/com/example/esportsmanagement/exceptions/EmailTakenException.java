package com.example.esportsmanagement.exceptions;

public class EmailTakenException extends Exception {
    public EmailTakenException() {}

    public EmailTakenException(String message) {
        super(message);
    }
}
