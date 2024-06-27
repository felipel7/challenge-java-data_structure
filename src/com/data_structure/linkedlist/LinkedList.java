package com.data_structure.linkedlist;

import java.util.NoSuchElementException;

public class LinkedList {

  private Node first;
  private Node last;
  private int size = 0;

  public void addLast(int item) {
    Node node = new Node(item);

      if (isEmpty()) {
          first = last = node;
      } else {
          last.next = node;
          last = node;
      }
    size++;
  }

  public void addFirst(int item) {
    Node node = new Node(item);

      if (isEmpty()) {
          first = last = node;
      } else {
          node.next = first;
          first = node;
      }
    size++;
  }

  public int indexOf(int item) {
    int index = 0;
    Node current = first;

    while (current != null) {
        if (current.value == item) {
            return index;
        }
      current = current.next;
      index++;
    }

    return -1;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public void removeFirst() {
      if (isEmpty()) {
          throw new NoSuchElementException();
      }

      if (hasOnlyOneNode()) {
          first = last = null;
      } else {
          Node second = first.next;
          first.next = null;
          first = second;
      }
    size--;
  }

  public void removeLast() {
      if (isEmpty()) {
          throw new NoSuchElementException();
      }

      if (hasOnlyOneNode()) {
          first = last = null;
      } else {
          Node previous = getPrevious(last);
          last = previous;
          last.next = null;
      }
    size--;
  }

  public int size() {
    return size;
  }

  public int[] toArray() {
    Node current = first;
    int[] array = new int[size];
    int index = 0;

    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }

    return array;
  }

  private Node getPrevious(Node node) {
    Node current = first;
    while (current != null) {
        if (current.next == node) {
            return current;
        }
      current = current.next;
    }

    return null;
  }

  private boolean isEmpty() {
    return first == null;
  }

  private boolean hasOnlyOneNode() {
    return first == last;
  }

  private class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
