package com.example.SpringBootDevStack.exception;

public class EntryNotFoundException extends RuntimeException{
    public EntryNotFoundException(String message){
        super(message);
    }
}
