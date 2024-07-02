package com.data_structure.linear.queue;

import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

  // Exercise 1 - Given an integer K and a queue, reverse the order of the first K elements
  public Queue<Integer> reverse(Queue<Integer> queue, int k) {
    if (k < 0 || k > queue.size()) {
      throw new IllegalArgumentException();
    }

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < k; i++) {
      stack.push(queue.remove());
    }

    while (!stack.isEmpty()) {
      queue.add(stack.pop());
    }

    for (int i = 0; i < queue.size(); i++) {
      queue.add(queue.remove());
    }

    return queue;
  }
}
