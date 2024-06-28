package com.data_structure;

import com.data_structure.queue.PriorityQueueWithArray;

public class Main {

  public static void main(String[] args) {

    PriorityQueueWithArray queue = new PriorityQueueWithArray();
    queue.insert(5);
    queue.insert(1);
    queue.insert(4);
    queue.insert(3);
    queue.insert(2);
    System.out.println(queue);
    System.out.println(queue.remove());
    System.out.println(queue.remove());
    System.out.println(queue);
  }
}
