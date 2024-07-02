package com.data_structure.linear.queue;


import java.util.ArrayList;

// Exercise 2 - Build a queue using a linked list from scratch
public class LinkedListQueue {

  private Node head;
  private Node tail;
  private int count;

  public void enqueue(int item) { // O(1)
    Node node = new Node(item);
    if (isEmpty()) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }

    count++;
  }

  public int dequeue() { // O(1)
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    int value;
    if (head == tail) {
      value = head.value;
      head = tail = null;
    } else {
      value = head.value;
      var second = head.next;
      head.next = null;
      head = second;
    }

    count--;

    return value;
  }

  public int peek() { // O(1)
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    return head.value;
  }

  private int size() { // O(1)
    return count;
  }

  private boolean isEmpty() {
    return head == null;
  }

  public String toString() {
    ArrayList<Integer> list = new ArrayList<>();

    Node current = head;
    while (current != null) {
      list.add(current.value);
      current = current.next;
    }

    return list.toString();
  }

  private class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
