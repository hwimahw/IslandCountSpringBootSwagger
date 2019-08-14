package ru.ncd;
import org.springframework.stereotype.Component;
@Component
public class Data {
    int n;
    int m;
    String matrix;
    int result;

    public int countResult(Matrix matrix, Graph graph) {
        int quantityOfDots = 0;
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                if (matrix.arrayMatrix[i][j] == '.') {
                    quantityOfDots++;
                }
            }
        }
        return graph.quantityOfIslands(graph) - quantityOfDots;
    }
}
