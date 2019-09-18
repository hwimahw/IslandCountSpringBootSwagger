package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.ncd.objects.Graph;
import ru.ncd.objects.Matrix;

import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class DataInitializerUnitTest {


    @Mock
    Matrix matrix;

    @Mock
    Graph graph;

    @Mock
    Data data;

    @Test
    public void testDataInitialize() {

        DataInitializer di = new DataInitializer();
        Mockito.when(matrix.getN()).thenReturn(1);
        Mockito.when(matrix.getM()).thenReturn(2);
        Mockito.when(matrix.toString()).thenReturn("##");
        Mockito.when(data.countResult(matrix, graph)).thenReturn(1);
        di.dataInitialize(data, matrix, graph);
        assertEquals("n is not right", 1, data.n);
        assertEquals("n is not right", 2, data.m);
        assertEquals("matrix is not right","##", data.matrix);
        assertEquals("result is not right", 1, data.result);
    }

}
