package org.sweetycode.clrs.graph;

import java.util.*;

/**
 * Created by tiantian on 2019/4/13.
 */
public class Dijkstra {

    private static class Vertex {
        int vIndex;

        public Vertex(int vIndex) {
            this.vIndex = vIndex;
        }
    }

    private static class Edge {
        int toIndex;
        int weight;

        public Edge(int toIndex, int weight) {
            this.toIndex = toIndex;
            this.weight = weight;
        }
    }

    private static class AdjacencyListGraph {
        private Vertex[] vertices;
        private LinkedList<Edge>[] adjs;
        private int size;

        private AdjacencyListGraph(int size) {
            this.size = size;
            vertices = new Vertex[size];
            adjs = new LinkedList[size];

            for (int i = 0; i < size; i ++) {
                vertices[i] = new Vertex(i);
                adjs[i] = new LinkedList<>();
            }
        }

        public void setAdjs(int from, int to, int weight) {
            adjs[from].add(new Edge(to, weight));
        }
        public int getSize() {
            return size;
        }

    }


    public static int[] dijkstra (AdjacencyListGraph graph, int start) throws Exception {
        int[] d = new int[graph.size];
        Arrays.fill(d, -1);
        d[start] = 0;

        HashSet<Integer> leftNodes = new HashSet<>();
        for (int i = 0; i < graph.size; i ++) {
            leftNodes.add(i);
        }

        Iterator<Integer> iterator;
        Integer minDistance;
        Integer findMinIndex = null;
        Integer var;
        while (!leftNodes.isEmpty()) {
            boolean connectedGraph = false;
            minDistance = Integer.MAX_VALUE;
            iterator = leftNodes.iterator();
            while (iterator.hasNext()) {
                var = iterator.next();
                if (d[var] != -1 && d[var] <= minDistance) {
                    minDistance = d[var];
                    findMinIndex = var;
                    connectedGraph = true;
                }
            }

            if (!connectedGraph) {
                throw new Exception("This is not a connected graph!");
            }
            leftNodes.remove(findMinIndex);

            for (Edge a : graph.adjs[findMinIndex]) {
                if (d[a.toIndex] == -1 || d[a.toIndex] > d[findMinIndex] + a.weight) {
                    d[a.toIndex] = d[findMinIndex] + a.weight;
                }
            }

        }
        return d;
    }


    public static void main(String[] args) throws Exception {
        AdjacencyListGraph graph = new AdjacencyListGraph(7);
        graph.setAdjs(0,1,5);
        graph.setAdjs(0,2,2);
        graph.setAdjs(1,0,5);
        graph.setAdjs(1,3,1);
        graph.setAdjs(1,4,6);
        graph.setAdjs(2,0,2);
        graph.setAdjs(2,3,6);
        graph.setAdjs(2,5,8);
        graph.setAdjs(3,1,1);
        graph.setAdjs(3,2,6);
        graph.setAdjs(3,4,1);
        graph.setAdjs(3,5,2);
        graph.setAdjs(4,1,6);
        graph.setAdjs(4,3,1);
        graph.setAdjs(4,6,7);
        graph.setAdjs(5,2,8);
        graph.setAdjs(5,3,2);
        graph.setAdjs(5,6,3);
        graph.setAdjs(6,4,7);
        graph.setAdjs(6,5,3);

        int[] d = dijkstra(graph, 4);
        System.out.println(Arrays.toString(d));

    }
}



