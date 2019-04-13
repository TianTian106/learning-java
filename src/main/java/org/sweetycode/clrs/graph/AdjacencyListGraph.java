package org.sweetycode.clrs.graph;

import java.util.LinkedList;

/**
 * Created by tiantian on 2019/4/13.
 */
public class AdjacencyListGraph {
    private int size;
    private Vertex[] vertices;
    private LinkedList<Integer>[] adjs;

    public void setAdjs(int index, Integer n) {
        adjs[index].add(n);
    }

    public int getSize() {
        return size;
    }

    public AdjacencyListGraph(int size) {
        this.size = size;
        vertices = new Vertex[size];
        adjs = new LinkedList[size];

        for (int i = 0; i < size; i ++) {
            vertices[i] = new Vertex(i);
            adjs[i] = new LinkedList<>();
        }
    }

    public static void dfs(AdjacencyListGraph graph, int start, boolean[] visited) {
        System.out.println(graph.vertices[start].data);
        visited[start] = true;
        for (int index : graph.adjs[start]) {
            if (visited[index]) {
                continue;
            } else {
                dfs(graph, index, visited);
            }
        }
    }

    public static void bfs(AdjacencyListGraph graph, int start, boolean[] visited) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        Integer c;
        while (!queue.isEmpty()) {
            c = queue.poll();
            System.out.println(graph.vertices[c].data);
            for (int index : graph.adjs[c]) {
                if (visited[index]) {
                    continue;
                } else {
                    queue.offer(index);
                    visited[index] = true;
                }
            }
        }

    }
}


class Vertex {
    int data;
    public Vertex(int data) {
        this.data = data;
    }
}