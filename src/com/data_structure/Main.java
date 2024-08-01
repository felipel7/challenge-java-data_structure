package com.data_structure;

import com.data_structure.non_linear.Trees.heaps.Heap;

public class Main {

  public static void main(String[] args) {
    Heap heap = new Heap();
    heap.insert(10);
    heap.insert(5);
    heap.insert(17);
    heap.insert(4);
    heap.insert(22);

    System.out.println(heap.remove());
    System.out.println(heap.remove());
  }
}