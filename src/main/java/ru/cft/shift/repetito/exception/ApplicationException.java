package ru.cft.shift.repetito.exception;

public class ApplicationException extends Exception {
    public ApplicationException(String message)
    {
        super(message);
    }
    public ApplicationException(String message,Throwable throwable)
    {
         super(message,throwable);
    }


}
