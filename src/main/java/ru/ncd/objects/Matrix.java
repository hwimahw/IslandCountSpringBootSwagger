package ru.ncd.objects;
import org.springframework.stereotype.Component;

@Component("matrix")
public class Matrix{
    public int n;
    public int m;
    public char[][] arrayMatrix;

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public char[][] getArrayMatrix() {
        return arrayMatrix;
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(arrayMatrix[i][j]);
                if(j == (m - 1)){
                    //sb.append('\n');
                }
            }
        }
        return sb.toString();
    }

    public char[] toOneDimensionalArray(char[][] arrayMatrix){
        char[] arr = new char[n*m];
        int k = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[k] = arrayMatrix[i][j];
                k++;
            }
        }
        return arr;
    }



}