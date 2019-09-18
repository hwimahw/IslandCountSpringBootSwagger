package ru.ncd;

import org.springframework.stereotype.Component;
import ru.ncd.objects.Graph;
import ru.ncd.objects.Matrix;

@Component
public class DataInitializer {



    public void dataInitialize(Data data, Matrix matrix, Graph graph){

            data.n = matrix.getN();
            data.m = matrix.getM();
            data.matrix = matrix.toString();
            data.result = data.countResult(matrix, graph);
    }
}
