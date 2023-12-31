package Graphs.BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Dijkstra{

    public int[] dijkstrasAlgorithm(int start, int[][][] edges) {

        HashMap<Integer, ArrayList<ArrayList<Integer>>> graph = new HashMap<>();
        int vertices = edges.length;

        boolean[] visited = new boolean[vertices];
        int[] distance  = new int[vertices];

        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);


        for(int i=0; i<vertices; i++){
            int out_vertices_len = edges[i].length;

            if(out_vertices_len == 0){
                ArrayList<ArrayList<Integer>> out = new ArrayList<>();
                graph.put(i, out);
            }
            for(int j=0; j<out_vertices_len; j++){
                ArrayList<Integer> vertex = new ArrayList<>();
                vertex.add(edges[i][j][0]);
                vertex.add(edges[i][j][1]);
                if(graph.get(i) != null){
                    graph.get(i).add(vertex);
                }
                else{
                    ArrayList<ArrayList<Integer>> out = new ArrayList<>();
                    out.add(vertex);
                    graph.put(i, out);
                }
            }
        }

        distance[start] = 0;
        while(getVertexWithMinDistance(visited, distance) != -1){
            int vertex_to_explore = getVertexWithMinDistance(visited, distance);
            visited[vertex_to_explore] = true;
            for(ArrayList<Integer> node : graph.get(vertex_to_explore)){
                int visit_node = node.get(0);
                int weight = node.get(1);
                int new_weight = distance[vertex_to_explore] == Integer.MAX_VALUE ? Integer.MAX_VALUE : weight + distance[vertex_to_explore];
                if(new_weight < distance[visit_node]){
                    distance[visit_node] = new_weight;
                }
            }
        }
        for(int i=0; i<vertices; i++){
            if(distance[i] == Integer.MAX_VALUE) distance[i] = -1;
        }
        //for(boolean i : visited) System.out.print(i + " ");
        return distance;

    }

    public int getVertexWithMinDistance(boolean[] visited, int[] distance){
        int len = visited.length;
        int minDistVertex = -1;
        for(int i=0; i<len; i++){
            if(visited[i] == false){
                if(minDistVertex == -1) minDistVertex = i;
                else{
                    if(distance[minDistVertex] > distance[i]){
                        minDistVertex = i;
                    }
                }
            }
        }
        return minDistVertex;
    }

}
