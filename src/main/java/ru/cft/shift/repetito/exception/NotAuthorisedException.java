package ru.cft.shift.repetito.exception;

public class NotAuthorisedException extends ApplicationException {
    public NotAuthorisedException()
    {
        super("");
    }
    public NotAuthorisedException(String message)
    {
        super(message);
    }
    public NotAuthorisedException(String message,Throwable throwable)
    {
        super(message,throwable);
    }

}
