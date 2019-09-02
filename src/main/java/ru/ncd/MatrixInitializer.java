package ru.ncd;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class MatrixInitializer {


    public void matrixInitialize(InputStream fileStream, Matrix matrix) throws InputMismatchException, IOException {
       Scanner sc = new Scanner(fileStream);
        matrix.n = sc.nextInt();
        matrix.m = sc.nextInt();
        sc.nextLine();
        matrix.arrayMatrix = new char[matrix.n][matrix.m];
        for (int i = 0; i < matrix.n; i++) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            System.arraycopy(arr, 0, matrix.arrayMatrix[i], 0, arr.length);
        }
    }
}
