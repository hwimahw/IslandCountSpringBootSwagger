package ru.ncd.handlers;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ncd.ErrorMessage;
import ru.ncd.exceptions.SizeMatrixException;
import ru.ncd.exceptions.FileResourceNotFoundException;
import ru.ncd.exceptions.MatrixException;

import java.util.InputMismatchException;

@RestControllerAdvice
public class ExceptionClientHandler{

    @ExceptionHandler(FileResourceNotFoundException.class)
    public ErrorMessage fileResourceNotFoundException(FileResourceNotFoundException ex){
            return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(MatrixException.class)
    public ErrorMessage matrixException(MatrixException ex){
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(SizeMatrixException.class)
    public ErrorMessage sizeMatrixException(SizeMatrixException ex){
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(InputMismatchException.class)
    public ErrorMessage InputMismatchException(InputMismatchException ex){
        return new ErrorMessage(ex.getMessage());
    }



}