package com.data_structure.linear.queue;


import java.util.Stack;

public class QueueWithTwoStacks {

  private Stack<Integer> stack1 = new Stack<>();
  private Stack<Integer> stack2 = new Stack<>();

  public void enqueue(int item) { // O(1)
    stack1.push(item);
  }

  public int dequeue() { // O(n)
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    moveStack1ToStack2();

    return stack2.pop();
  }

  private void moveStack1ToStack2() {
    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    moveStack1ToStack2();

    return stack2.peek();
  }

  public boolean isEmpty() {
    return stack1.isEmpty() && stack2.isEmpty();
  }
}
