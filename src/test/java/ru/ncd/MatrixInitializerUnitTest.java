package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.*;
import java.io.FileInputStream;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class MatrixInitializerUnitTest {

    @Test
    public void testMatrixInitialize() throws FileNotFoundException, IOException {
        Matrix matrix = new Matrix();
        MatrixInitializer mi = new MatrixInitializer();
        InputStream fileStream = new FileInputStream("./src/test/resources/input.txt");
        mi.matrixInitialize(fileStream, matrix);
        assertEquals("Quantity of rows is read from file with errors", 1, matrix.n);
        assertEquals("Quantity of columns is read from file with errors", 2, matrix.m);
        char[] arr1 = {'#', '#'};
        assertArrayEquals("Matrix is read from file with errors", arr1, matrix.toOneDimensionalArray(matrix.arrayMatrix));
    }
}
