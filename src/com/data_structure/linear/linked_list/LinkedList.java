package com.data_structure.linear.linked_list;

import java.util.NoSuchElementException;

public class LinkedList {

  private Node first;
  private Node last;
  private int size = 0;

  public static LinkedList createWithLoop() {
    var list = new LinkedList();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    var node = list.last;

    list.addLast(40);
    list.addLast(50);

    list.last.next = node;

    return list;
  }

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
    int[] array = new int[size];
    Node current = first;
    int index = 0;

    while (current != null && index < size) {
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

  // Exercise 1 - find the middle of a linked list in one pass
  public void printMiddle() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    var firstPointer = first;
    var secondPointer = first;

    while (secondPointer != last && secondPointer.next != last) {
      secondPointer = secondPointer.next.next;
      firstPointer = firstPointer.next;
    }

    if (secondPointer == last) {
      System.out.println(firstPointer.value); // odd
    } else {
      System.out.println(
          firstPointer.value + ", " + firstPointer.next.value); // even number of nodes
    }
  }

  // Exercise 2 - Check to see if a linked list has a loop
  public boolean hasLoop() {
    var slow = first;
    var fast = first;

    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) {
        return true;
      }
    }
    return false;
  } // Floyd’s Cycle-finding Algorithm implementation

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
