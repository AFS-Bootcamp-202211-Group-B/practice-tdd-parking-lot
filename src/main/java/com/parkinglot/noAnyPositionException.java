package com.parkinglot;

public class noAnyPositionException extends RuntimeException{
    public noAnyPositionException() {
        super("No available position.");
    }
}
