package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DataInitializerUnitTest {
    @Autowired
    Matrix matrix;

    @Autowired
    MatrixInitializer mi;

    @Autowired
    Graph graph;

    @Autowired
    GraphInitializer gi;

    @Autowired
    Data data;

    @Autowired
    DataInitializer di;

    @Test
    public void testDataInitialize() throws FileNotFoundException {

        InputStream fileStream = new FileInputStream("/home/mansur/IdeaProjects/IslandCountSpringBoot/src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        gi.graphInitialize(graph, matrix);
        DataInitializer di = new DataInitializer();
        di.dataInitialize(data, matrix, graph);
        assertEquals("n is not right", 1, data.n);
        assertEquals("n is not right", 2, data.m);
        assertEquals("matrix is not right","##", data.matrix);
        assertEquals("result is not right", 1, data.result);
    }

}
