package com.data_structure;

import com.data_structure.linkedlist.LinkedList;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);
    list.removeLast();

    list.addFirst(1);
    list.removeFirst();

    System.out.println("List size: " + list.size());
    System.out.println("index: " + list.indexOf(10));
    System.out.println("contains: " + list.contains(1));

    int[] array = list.toArray();
    System.out.println("LL -> Array: " + Arrays.toString(array));
  }
}
