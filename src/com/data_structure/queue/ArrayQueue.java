package com.data_structure.queue;

import java.util.Arrays;

public class ArrayQueue {

  private int count = 0;
  private int front = 0;
  private int rear = 0;
  private int[] items;

  public ArrayQueue(int capacity) {
    this.items = new int[capacity];
  }

  public void enqueue(int item) {
    if (count == items.length) {
      throw new IllegalStateException();
    }

    items[rear] = item;
    rear = (rear + 1) % items.length; // circular array
    count++;
  }

  public int dequeue() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    int item = items[front];
    items[front] = 0;
    front = (front + 1) % items.length; // circular array
    count--;
    return item;
  }

  public int peek() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    return items[front];
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == items.length;
  }

  @Override
  public String toString() {
    return Arrays.toString(items);
  }
}
