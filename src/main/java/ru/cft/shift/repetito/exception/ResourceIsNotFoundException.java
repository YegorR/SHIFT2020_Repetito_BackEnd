package ru.cft.shift.repetito.exception;

public class ResourceIsNotFoundException extends ApplicationException {
    public ResourceIsNotFoundException() {
        super("");
    }
    public ResourceIsNotFoundException(String message) {
        super(message);
    }
    public ResourceIsNotFoundException(String message,Throwable throwable)
    {
        super(message,throwable);
    }
}
