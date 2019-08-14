package ru.ncd;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component("graph")
public class Graph {

    public int n;
    public char[][] arrayGraph;
    public int[] numberOfConnectedComponent;

    public Graph(Matrix matrix) {
        this.n = matrix.n * matrix.m;
        arrayGraph = new char[n][n];
        numberOfConnectedComponent = new int[n];
    }

    public void toZerosNumberOfConnectedComponent(int[] numberOfConnectedComponent){
        for(int i = 0; i < numberOfConnectedComponent.length; i++){
            numberOfConnectedComponent[i] = 0;
        }
    }

    public String toString(){
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arrayGraph[i][j]);
                if(j == (n - 1)){
                    sb.append('\n');
                }
            }
        }
        return sb.toString();
    }


    public int quantityOfIslands(Graph graph){
        toZerosNumberOfConnectedComponent(numberOfConnectedComponent);
        ArrayList<Island> islands = new ArrayList<>();
        int quantityOfConnectedComponent = 0;
        for(int i = 0; i < graph.n; i++){
            Island island;
            if(numberOfConnectedComponent[i] == 0){
                island = new Island();
                quantityOfConnectedComponent++;
                dfs(i, quantityOfConnectedComponent, island);
                islands.add(island);
            }
        }

        return islands.size();
    }


    public void dfs(int i, int quantity, Island island){
        island.add(i);
        numberOfConnectedComponent[i] = quantity;
        for(int j = 0; j < arrayGraph.length; j++){
            if(arrayGraph[i][j] == '1' && numberOfConnectedComponent[j] == 0){
                dfs(j, quantity, island);
            }
        }
    }

}
