package ru.ncd;

public class DataInitializer {

    public void dataInitialize(Data data, Matrix matrix, Graph graph){

            data.n = matrix.n;
            data.m = matrix.m;
            data.matrix = matrix.toString();
            data.result = data.countResult(matrix, graph);
    }
}
