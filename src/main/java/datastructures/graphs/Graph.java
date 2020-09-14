package datastructures.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private int V; //number of vertices

    private LinkedList<Integer> adj[]; //adjacency list

    public Graph(final int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public List<Integer> bfs(int startV) {

        boolean visited[] = new boolean[V];
        visited[startV] = true;

        List<Integer> result = new LinkedList<>();
        result.add(startV);

        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(adj[startV]);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            result.add(poll);
            final LinkedList<Integer> neighbours = adj[poll];
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }

    public List<Integer> dfs(int startV) {

        boolean visited[] = new boolean[V];
        visited[startV] = true;

        List<Integer> result = new LinkedList<>();
        result.add(startV);

        Stack<Integer> stack = new Stack<>();
        stack.addAll(adj[startV]);
        while (!stack.isEmpty()) {
            Integer poll = stack.pop();
            visited[poll] = true;
            result.add(poll);
            final LinkedList<Integer> neighbours = adj[poll];
            for (Integer neighbour : neighbours) {
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                }
            }
        }
        return result;
    }

    public void print() {
        for (int i = 0; i < adj.length; i++) {
            System.out.println(i + ": " + adj[i]);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        graph.addEdge(2, 0);
        graph.addEdge(5, 4);
        graph.print();

        System.out.println(graph.bfs(0));
    }
}
