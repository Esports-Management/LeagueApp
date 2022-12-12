package com.example.esportsmanagement.exceptions;

public class UserNameTakenException extends Exception {
    public UserNameTakenException() {}

    public UserNameTakenException(String message) {
        super(message);
    }
}
