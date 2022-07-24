package com.graduationProjectPatika.Exceptions;

public class BalanceInsufficientException extends Exception{

    //If the amount entered the invoice payment process is less than the invoice amount, an exception message is generated.

    String message;
    public BalanceInsufficientException(String message){
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
