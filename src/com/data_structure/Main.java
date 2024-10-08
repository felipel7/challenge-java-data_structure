package com.data_structure;

import com.data_structure.non_linear.Graphs.Graph;

public class Main {

  public static void main(String[] args) {
    var graph = new Graph();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addEdge("A", "B");
    graph.addEdge("A", "C");
    graph.addEdge("A", "D");

    graph.print();

    graph.removeEdge("A", "C");
    graph.removeNode("D");

    graph.print();

    graph.addNode("E");
    graph.addEdge("A", "E");
    graph.traverseDepthFirstRec("A");

    graph.print();

    System.out.println("traverseBreadthFirst");
    graph.traverseBreadthFirst("A");

    var list = graph.topologicalSort();
    System.out.println(list);

    System.out.println(graph.hasCycle());
    graph.addEdge("E", "A");
    System.out.println(graph.hasCycle());
  }
}