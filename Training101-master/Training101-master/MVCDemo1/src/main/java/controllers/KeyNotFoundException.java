package controllers;

public class KeyNotFoundException extends RuntimeException {

    public KeyNotFoundException(String message) {
        super(message);
    }
}
