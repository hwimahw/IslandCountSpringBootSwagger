package ru.ncd;

import org.junit.Test;
import ru.ncd.objects.Matrix;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
public class MatrixUnitTest {

    @Test
    public void testToString() throws FileNotFoundException, IOException {
        Matrix matrix = new Matrix();
        matrix.n = 2;
        matrix.m = 2;
        matrix.arrayMatrix = new char[2][2];
        matrix.arrayMatrix[0][0] = '#';
        matrix.arrayMatrix[0][1] = '.';
        matrix.arrayMatrix[1][0] = '#';
        matrix.arrayMatrix[1][1] = '.';
        String str = matrix.toString();
        assertEquals("string matrix is not right","#.#.", str);

    }

    @Test
    public void testToOneDimensionalArray() {
        Matrix matrix = new Matrix();
        matrix.n = 2;
        matrix.m = 2;
        matrix.arrayMatrix = new char[2][2];
        matrix.arrayMatrix[0][0] = '#';
        matrix.arrayMatrix[0][1] = '.';
        matrix.arrayMatrix[1][0] = '#';
        matrix.arrayMatrix[1][1] = '.';
        char[] arr1 = {'#','.','#','.'};
        char[] arr2 = matrix.toOneDimensionalArray(matrix.arrayMatrix);
        assertArrayEquals("Error", arr1, arr2);


    }
}
