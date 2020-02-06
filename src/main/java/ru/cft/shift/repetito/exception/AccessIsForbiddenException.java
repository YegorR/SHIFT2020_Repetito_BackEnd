package ru.cft.shift.repetito.exception;

public class AccessIsForbiddenException extends ApplicationException {

    public AccessIsForbiddenException(String message)
    {
        super(message);
    }
    public AccessIsForbiddenException(String message,Throwable throwable)
    {
        super(message,throwable);
    }
}
