package ru.ncd;

public class SqlException extends RuntimeException {

    String message;

    public SqlException(String message){
        this.message = message;

    }
}
