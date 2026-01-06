package Graphs;

import java.util.*;

public class Representation {
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static void printGraph(ArrayList<Edge>[] graph){
        for(int i = 0; i < graph.length; i++){
            System.out.println(i + " -> ");
            for(Edge e : graph[i]){
                System.out.println("  (" + e.src + " -> " + e.dest + " , wt: " + e.wt + ")");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Graph Representation in Java");
        int vrcs = 7;
        ArrayList<Edge>[] graph = new ArrayList[vrcs];
        for(int i=0; i<vrcs; i++){
            graph[i] = new ArrayList<Edge>();
        }

        // adding edges
        graph[0].add(new Edge(0, 3, 40));
        graph[0].add(new Edge(0, 1, 10));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 2, 10));

        graph[2].add(new Edge(2, 3, 10));
        graph[2].add(new Edge(2, 1, 10));

        graph[3].add(new Edge(3, 0, 40));
        graph[3].add(new Edge(3, 2, 10));
        graph[3].add(new Edge(3, 4, 2));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 3));
        graph[4].add(new Edge(4, 6, 3));

        graph[5].add(new Edge(5, 4, 3));
        graph[5].add(new Edge(5, 6, 3));

        graph[6].add(new Edge(6, 5, 3));
        graph[6].add(new Edge(6, 4, 8));

        System.out.println("Graph Representation:");
        printGraph(graph);

    }
}
