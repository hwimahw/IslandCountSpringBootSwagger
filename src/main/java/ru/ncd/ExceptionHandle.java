package ru.ncd;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.util.InputMismatchException;

@RestControllerAdvice
public class ExceptionHandle{

    @ExceptionHandler(FileResourceNotFoundException.class)
    public ErrorMessage fileResourceNotFoundException(FileResourceNotFoundException ex){
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ErrorMessage sqlException(SqlException ex){
        return new ErrorMessage(ex.getMessage());
    }

    @ExceptionHandler(MatrixException.class)
    public ErrorMessage matrixException(InputMismatchException ex){
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

    @ExceptionHandler(Exception.class)
    public ErrorMessage Exception(Exception ex){
        return new ErrorMessage(ex.getMessage());
    }

}
