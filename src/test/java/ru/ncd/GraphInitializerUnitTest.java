package ru.ncd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import ru.ncd.objectInitializers.GraphInitializer;
import ru.ncd.objects.Graph;
import ru.ncd.objects.Matrix;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
@RunWith(MockitoJUnitRunner.class)
public class GraphInitializerUnitTest {

    @Mock
    Matrix matrix;


    @Test
    public void testGraphInitialize() throws Exception {
        GraphInitializer gi = new GraphInitializer();
        Mockito.when(matrix.getN()).thenReturn(1);
        Mockito.when(matrix.getM()).thenReturn(2);
        char[][] arrayMatrix = {{'#','#'}};
        Mockito.when(matrix.getArrayMatrix()).thenReturn(arrayMatrix);
        Graph graph = new Graph(matrix);
        gi.graphInitialize(graph, matrix);
        assertEquals("Size of arrayGraph is not right", 2, graph.getN());
        char[] arr1 = {'1', '1', '1', '1'};
        assertArrayEquals("graphMatrix is build with errors", arr1, graph.toOneDimensionalArray(graph.arrayGraph));

    }

    @Test
    public void testFillGraph() throws Exception {
        Mockito.when(matrix.getN()).thenReturn(1);
        Mockito.when(matrix.getM()).thenReturn(2);
        Graph graph = new Graph(matrix);
        char[][] arrayMatrix = {{'#','#'}};
        Mockito.when(matrix.getArrayMatrix()).thenReturn(arrayMatrix);
        GraphInitializer gi = new GraphInitializer();
        gi.fillGraph(graph, matrix, 1, 2);
        char[] arr1 = {'1', '1', '1', '1'};
        assertArrayEquals("graphMatrix is build with errors", arr1, graph.toOneDimensionalArray(graph.arrayGraph));
    }

}
