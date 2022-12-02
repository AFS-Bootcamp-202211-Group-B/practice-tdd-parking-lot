package com.parkinglot;

public class unrecognizedTicketException extends RuntimeException{
    public unrecognizedTicketException() {
        super("Unrecognized parking ticket.");
    }
}
