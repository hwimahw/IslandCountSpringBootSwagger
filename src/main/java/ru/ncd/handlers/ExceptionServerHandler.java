package ru.ncd.handlers;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ncd.ErrorMessage;
import ru.ncd.exceptions.MatrixException;

import java.sql.SQLException;
import java.util.InputMismatchException;

@RestControllerAdvice
public class ExceptionServerHandler{

    @ExceptionHandler(SQLException.class)
    public ErrorMessage SqlException(SQLException ex){
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(ClassNotFoundException.class)
    public ErrorMessage classNotFoundException(ClassNotFoundException ex){
        return new ErrorMessage(ex.getMessage());
    }


}