package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class GraphInitializerUnitTest {
    Matrix matrix;
    MatrixInitializer mi;
    Graph graph;
    GraphInitializer gi;

    @Autowired
    public void setMi(MatrixInitializer mi) {
        this.mi = mi;
    }
    @Autowired
    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }

    @Autowired
    public void setGraph(Graph graph) {
        this.graph = graph;
    }
    @Autowired
    public void setGi(GraphInitializer gi) {
        this.gi = gi;
    }

    @Test
    public void testGraphInitialize() throws FileNotFoundException {
        InputStream fileStream = new FileInputStream("/home/mansur/IdeaProjects/IslandCountSpringBoot/src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        gi.graphInitialize(graph, matrix);
        assertEquals("Size of arrayGraph is not right", 2, graph.n);
        int size = graph.n * graph.n;
        char[] arr1 = {'1', '1', '1', '1'};
        char[] arr2 = new char[size];
        int k = 0;
        for(int i = 0; i < graph.n; i++){
            for(int j = 0; j < graph.n; j++){
                arr2[k] = graph.arrayGraph[i][j];
                k++;
            }
        }
        assertArrayEquals("graphMatrix is build with errors", arr1, arr2);

    }

    @Test
    public void testFillGraph() throws FileNotFoundException {
        InputStream fileStream = new FileInputStream("/home/mansur/IdeaProjects/IslandCountSpringBoot/src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        gi.graphInitialize(graph, matrix);
        gi.fillGraph(graph, matrix, matrix.n, matrix.m);
        char[] arr1 = {'1', '1', '1', '1'};
        assertArrayEquals("graphMatrix is build with errors", arr1, graph.toString().toCharArray());
    }

}
