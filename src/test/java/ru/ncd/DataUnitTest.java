package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataUnitTest {
    @Autowired
    Matrix matrix;

    @Autowired
    MatrixInitializer mi;

    @Autowired
    Graph graph;

    @Autowired
    GraphInitializer gi;

    @Test
    public void testCountResult() throws FileNotFoundException {
        InputStream fileStream = new FileInputStream("/home/mansur/IdeaProjects/IslandCountSpringBoot/src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        gi.graphInitialize(graph, matrix);
        assertEquals("result is not right", 1, new Data().countResult(matrix, graph));
    }
}
