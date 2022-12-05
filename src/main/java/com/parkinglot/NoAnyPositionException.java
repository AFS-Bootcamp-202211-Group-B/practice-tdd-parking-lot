package com.parkinglot;

public class NoAnyPositionException extends RuntimeException{
    public NoAnyPositionException() {
        super("No available position.");
    }
}
