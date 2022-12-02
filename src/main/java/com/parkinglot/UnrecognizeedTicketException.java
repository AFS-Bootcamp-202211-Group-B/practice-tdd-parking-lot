package com.parkinglot;

public class UnrecognizeedTicketException extends RuntimeException{
    public UnrecognizeedTicketException() {
        super("Unrecognized parking ticket");
    }

}
