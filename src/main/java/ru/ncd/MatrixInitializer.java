package ru.ncd;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class MatrixInitializer {

    public InputStream fileStream;


    public void matrixInitialize(InputStream fileStream, Matrix matrix) throws FileNotFoundException {
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
