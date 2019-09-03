package ru.ncd;
import org.springframework.stereotype.Component;
@Component
public class Data {
    int n;
    int m;
    String matrix;
    int result;


    public  int countResult(Matrix matrix, Graph graph) {
        int quantityOfDots = 0;
        for (int i = 0; i < matrix.getN(); i++) {
            for (int j = 0; j < matrix.getM(); j++) {
                if (matrix.getArrayMatrix()[i][j] == '.') {
                    quantityOfDots++;
                }
            }
        }
        return graph.quantityOfIslands(graph) - quantityOfDots;
    }

}
