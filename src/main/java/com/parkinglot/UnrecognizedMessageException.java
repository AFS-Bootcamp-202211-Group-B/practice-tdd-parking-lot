package com.parkinglot;

public class UnrecognizedMessageException extends RuntimeException{
    UnrecognizedMessageException(){
        super("Unrecognized parking ticket.");
    }
}
