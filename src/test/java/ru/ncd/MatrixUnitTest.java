package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MatrixUnitTest {
    @Autowired
    Matrix matrix;

    @Autowired
    MatrixInitializer mi;

    @Test
    public void testToString() throws FileNotFoundException {
        InputStream fileStream = new FileInputStream("/home/mansur/IdeaProjects/IslandCountSpringBoot/src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                sb.append(matrix.arrayMatrix[i][j]);
                if (j == (matrix.m - 1)) {
                }
            }
        }
        assertEquals("string matrix is not right","##", sb.toString());

    }
}
