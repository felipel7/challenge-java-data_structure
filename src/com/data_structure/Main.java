package com.data_structure;

import com.data_structure.queue.ArrayQueue;

public class Main {

  public static void main(String[] args) {

    ArrayQueue arrayQueue = new ArrayQueue(5);
    arrayQueue.enqueue(10);
    arrayQueue.enqueue(20);
    arrayQueue.enqueue(30);
    arrayQueue.dequeue();
    arrayQueue.dequeue();
    arrayQueue.enqueue(40);
    arrayQueue.enqueue(50);
    arrayQueue.enqueue(60);
    System.out.println(arrayQueue);
    System.out.println(arrayQueue.peek());
  }
}
