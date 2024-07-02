package com.data_structure;

import com.data_structure.linear.array.Array;
import com.data_structure.linear.hash_tables.HashMap;
import com.data_structure.linear.linked_list.LinkedList;
import com.data_structure.linear.queue.LinkedListQueue;
import com.data_structure.linear.queue.QueueReverser;
import com.data_structure.linear.queue.QueueWithArray;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    // Array
    Array array = new Array(3);
    array.addItem(10);
    array.addItem(90);
    array.addItem(30);
    System.out.println("\nThe maximum number in the array is: " + array.max());

    Array other = new Array(3);
    other.addItem(10);
    other.addItem(20);
    other.addItem(30);
    var result = array.intersect(other);
    System.out.println("\nIntersection between the two arrays: ");
    result.print();

    other.reverse();
    System.out.println("\nReversed array: ");
    other.print();

    // Linked Lists
    LinkedList linkedList = new LinkedList();
    linkedList.addLast(20);
    linkedList.addLast(30);
    linkedList.addFirst(10);
    linkedList.addLast(40);
    linkedList.addLast(50);
    linkedList.addLast(60);
    linkedList.removeLast();
    System.out.println("\nLinked List: " + Arrays.toString(linkedList.toArray()));
    System.out.print("Middle node(s) of the linked list: ");
    linkedList.printMiddle();
    System.out.println("This linked list has loop? " + linkedList.hasLoop());
    // With loop
    var list = LinkedList.createWithLoop();
    System.out.println(
        "This list: " + Arrays.toString(list.toArray()) + " has loop? " + list.hasLoop());

    // Queue with Array
    QueueWithArray queue = new QueueWithArray(4);
    queue.isEmpty();
    queue.enqueue(10);
    queue.enqueue(20);
    queue.enqueue(40);
    queue.enqueue(30);
    System.out.println("\nQueue with array: " + queue.toString());
    // reverse queue
    Queue<Integer> queueToBeReverse = new java.util.LinkedList<>();
    queueToBeReverse.add(10);
    queueToBeReverse.add(20);
    queueToBeReverse.add(30);
    queueToBeReverse.add(40);
    QueueReverser queueReverser = new QueueReverser();
    var queueReversed = queueReverser.reverse(queueToBeReverse, 3);
    System.out.println("Reversed queue: " + queueReversed);
    // Queue with linked list
    LinkedListQueue linkedListQueue = new LinkedListQueue();
    linkedListQueue.enqueue(10);
    linkedListQueue.enqueue(20);
    linkedListQueue.enqueue(30);
    linkedListQueue.dequeue();
    System.out.println("Queue with linked list: " + linkedListQueue.toString());

    // HashMap
    HashMap hashMap = new HashMap();
    hashMap.put(0, "firstValue");
    hashMap.put(1, "SecondValue");
    hashMap.put(2, "ThirdValue");
    hashMap.remove(2);
    System.out.println("\nHashMap: " + hashMap.toString());
    System.out.println(hashMap.get(1));
  }
}
