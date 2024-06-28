package com.data_structure;

import com.data_structure.queue.QueueWithStacks;

public class Main {

  public static void main(String[] args) {

    QueueWithStacks queue = new QueueWithStacks();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(30);
    System.out.println(queue.dequeue());
    System.out.println(queue.dequeue());
    System.out.println(queue.peek());
    System.out.println(queue.peek());
  }
}
