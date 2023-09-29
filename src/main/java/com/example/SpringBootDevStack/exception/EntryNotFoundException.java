package com.example.SpringBootDevStack.exception;

public class EntryNotFoundException extends RuntimeException{
    private String message;

    public EntryNotFoundException(String message){
        super(message);
    }
}
