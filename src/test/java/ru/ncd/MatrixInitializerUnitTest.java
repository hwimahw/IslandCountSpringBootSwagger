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
public class MatrixInitializerUnitTest {

    @Autowired
    Matrix matrix;

    @Autowired
    MatrixInitializer mi;

    @Test
    public void testMatrixInitialize() throws FileNotFoundException {
        InputStream fileStream = new FileInputStream("/home/mansur/IdeaProjects/IslandCountSpringBoot/src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        assertEquals("Quantity of rows is read from file with errors", 1, matrix.n);
        assertEquals("Quantity of columns is read from file with errors", 2, matrix.m);
        char[] arr1 = {'#', '#'};
        int size = matrix.n * matrix.m;
        char[] arr2 = new char[size];
        int k = 0;
        for(int i = 0; i < matrix.n; i++) {
            for(int j = 0; j < matrix.m; j++) {
                arr2[k] = matrix.arrayMatrix[i][j];
                k++;
            }
        }
        assertArrayEquals("Matrix is read from file with errors", arr1, arr2);
    }
}
