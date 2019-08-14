package ru.ncd;
import org.springframework.stereotype.Component;

@Component("matrix")
public class Matrix{
    public int n;
    public int m;
    public char[][] arrayMatrix;


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



}