package org.sweetycode.clrs.graph;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.LinkedList;

/**
 * AdjacencyListGraph Tester.
 *
 * @author <Authors name>
 * @since <pre>Apr 13, 2019</pre>
 * @version 1.0
 */
public class AdjacencyListGraphTest {
    AdjacencyListGraph graph = new AdjacencyListGraph(6);

    @Before
    public void before() throws Exception {
        graph.setAdjs(0, 1);
        graph.setAdjs(0, 2);
        graph.setAdjs(0, 3);
        graph.setAdjs(1, 0);
        graph.setAdjs(1, 3);
        graph.setAdjs(1, 4);
        graph.setAdjs(2, 0);
        graph.setAdjs(3, 0);
        graph.setAdjs(3, 1);
        graph.setAdjs(3, 4);
        graph.setAdjs(3, 5);
        graph.setAdjs(4, 1);
        graph.setAdjs(4, 3);
        graph.setAdjs(4, 5);
        graph.setAdjs(5, 3);
        graph.setAdjs(5, 4);
    }

    @After
    public void after() throws Exception {
    }

    /**
     *
     * Method: dfs(AdjacencyListGraph graph, int start, boolean[] visited)
     *
     */
    @Test
    public void testDfs() throws Exception {
        //TODO: Test goes here...
    }

    /**
     *
     * Method: bfs(AdjacencyListGraph graph, int start, boolean[] visited)
     *
     */
    @Test
    public void testBfs() throws Exception {
        //TODO: Test goes here...
    }

    @Test
    public void test() throws Exception {
        System.out.println("dfs: ");
        AdjacencyListGraph.dfs(graph, 0, new boolean[graph.getSize()]);

        System.out.println("bfs: ");
        AdjacencyListGraph.bfs(graph, 0, new boolean[graph.getSize()]);
    }
}
