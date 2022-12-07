package com.example.esportsmanagement.exceptions;

public class NickNameTakenException extends Exception {
    public NickNameTakenException() {}

    public NickNameTakenException(String message) {
        super(message);
    }
}
