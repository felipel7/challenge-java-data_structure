package com.data_structure.queue;

import java.util.Stack;

public class QueueWithStacks {

  Stack<Integer> stackForQueue = new Stack<>();
  Stack<Integer> stackForDequeue = new Stack<>();

  public void enqueue(int item) {
    stackForQueue.push(item);
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    moveStackFromQueueToDequeue();

    return stackForDequeue.pop();
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    moveStackFromQueueToDequeue();

    return stackForDequeue.peek();
  }

  private void moveStackFromQueueToDequeue() {
    if (stackForDequeue.isEmpty()) {
      while (!stackForQueue.isEmpty()) {
        stackForDequeue.push(stackForQueue.pop());
      }
    }
  }

  public boolean isEmpty() {
    return stackForQueue.isEmpty() && stackForDequeue.isEmpty();
  }
}
