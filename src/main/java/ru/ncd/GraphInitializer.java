package ru.ncd;

public class GraphInitializer {
    public void graphInitialize(Graph graph, Matrix matrix) {
        graph.n = matrix.n * matrix.m;
        graph.arrayGraph = new char[graph.n][graph.n];
        graph.numberOfConnectedComponent = new int[graph.n];
        fillGraph(graph, matrix, matrix.n, matrix.m);
    }


    public void fillGraphMiddlePartOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m){
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                graph.arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                graph.arrayGraph[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                graph.arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                graph.arrayGraph[i * m + (j + 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                graph.arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                graph.arrayGraph[(i + 1) * m + j][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                graph.arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                graph.arrayGraph[(i - 1) * m + j][i * m + j] = '1';
            }
        }



    }

    public void fillGraphFirstRowOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m){
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                graph.arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                graph.arrayGraph[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                graph.arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                graph.arrayGraph[i * m + (j + 1)][i * m + j] = '1';
            }
            if(n > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                    graph.arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                    graph.arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                }
            }
        }
    }

    public void fillGraphLastRowOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                graph.arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                graph.arrayGraph[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                graph.arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                graph.arrayGraph[i * m + (j + 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                graph.arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                graph.arrayGraph[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }

    public void fillGraphFirstColumnOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                    graph.arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                    graph.arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                }
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                graph.arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                graph.arrayGraph[(i + 1) * m + j][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                graph.arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                graph.arrayGraph[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }


    public void fillGraphLeftUpAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {////////////////+++++++++++
                    graph.arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                    graph.arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                }
            }
            if(n > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                    graph.arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                    graph.arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                }
            }
        }
    }
    public void fillGraphRightUpAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                    graph.arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                    graph.arrayGraph[i * m + (j - 1)][i * m + j] = '1';
                }
            }
            if(n > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                    graph.arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                    graph.arrayGraph[(i + 1) * m + j][i * m + j] = '1';
                }
            }
        }
    }

    public void fillGraphLeftDownAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if(m > 1) {
                if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j + 1]) {
                    graph.arrayGraph[i * m + j][i * m + (j + 1)] = '1';
                    graph.arrayGraph[i * m + (j + 1)][i * m + j] = '1';
                }
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                graph.arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                graph.arrayGraph[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }

    public void fillGraphRightDownAngleOfMatrix(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                graph.arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                graph.arrayGraph[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                graph.arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                graph.arrayGraph[(i - 1) * m + j][i * m + j] = '1';
            }
        }
    }


    public void fillGraphLastColumnOfMatrixWithoutFirstAndLast(Graph graph, Matrix matrix, int i, int j, int n, int m) {
        if (matrix.arrayMatrix[i][j] == '#') {
            graph.arrayGraph[i * m + j][i * m + j] = '1';
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i][j - 1]) {
                graph.arrayGraph[i * m + j][i * m + (j - 1)] = '1';
                graph.arrayGraph[i * m + (j - 1)][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i + 1][j]) {
                graph.arrayGraph[i * m + j][(i + 1) * m + j] = '1';
                graph.arrayGraph[(i + 1) * m + j][i * m + j] = '1';
            }
            if (matrix.arrayMatrix[i][j] == matrix.arrayMatrix[i - 1][j]) {
                graph.arrayGraph[i * m + j][(i - 1) * m + j] = '1';
                graph.arrayGraph[(i - 1) * m + j][i * m + j] = '1';
            }
        }

    }

    public void fillGraph(Graph graph, Matrix matrix, int n, int m) {
        for (int i = 0; i < graph.n; i++) {
            for (int j = 0; j < graph.n; j++) {
                graph.arrayGraph[i][j] = '0';
            }
        }
        if(n >= 1 && m >= 1){

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i >= 1 && i <= n - 2) && (j >= 1 && j <= m - 2)) {
                    fillGraphMiddlePartOfMatrix(graph, matrix, i, j, n, m);
                }
                else if(i == 0 && (j >= 1 && j <= m - 2)) {
                    fillGraphFirstRowOfMatrixWithoutFirstAndLast(graph, matrix, i, j, n, m);
                }
                else if((i == (n - 1)) && (j >= 1 && j <= m - 2)){
                    fillGraphLastRowOfMatrixWithoutFirstAndLast(graph, matrix, i, j, n, m);
                }
                else if((j == 0) && (i >= 1 && i <= n - 2)){
                    fillGraphFirstColumnOfMatrixWithoutFirstAndLast(graph,matrix, i, j, n, m);
                }
                else if((j == (m - 1)) && (i >= 1 && i <= n - 2)){
                    fillGraphLastColumnOfMatrixWithoutFirstAndLast(graph, matrix, i, j, n, m);
                }
                else if(i == 0 && j == 0){
                    fillGraphLeftUpAngleOfMatrix(graph, matrix, i, j, n, m);
                }
                else if(i == 0 && j == m - 1){
                    fillGraphRightUpAngleOfMatrix(graph, matrix, i, j, n, m);
                }
                else if((i == (n - 1)) && j == 0){
                    fillGraphLeftDownAngleOfMatrix(graph, matrix, i, j, n, m);
                }
                else if((i == (n - 1)) && (j == (m - 1))){
                    fillGraphRightDownAngleOfMatrix(graph, matrix, i, j, n, m);
                }
            }
        }
    }

}
