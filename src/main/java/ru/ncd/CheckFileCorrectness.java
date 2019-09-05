package ru.ncd;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileInputStream;


public class CheckFileCorrectness {

    public void check(InputStream inputStream) throws Exception, InputMismatchException, MatrixException, SizeMatrixException {
        Scanner sc = new Scanner(inputStream);
        int quantityOfRows = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        while(sc.hasNextLine()){
            quantityOfRows++;
            String str = sc.nextLine();
            if(str.length() != m){
                throw new SizeMatrixException("Quantity of columns is not valid");
            }
            char[] arr = str.toCharArray();
            for(int i = 0; i < arr.length; i++){
                if((int)(arr[i]) != 35 && (int)(arr[i]) != 46){
                    throw new MatrixException("Invalid symbol in Matrix");
                }
            }
        }
        if(quantityOfRows != n){
            throw new SizeMatrixException("Quantity of rows is not valid");
        }

    }
}
