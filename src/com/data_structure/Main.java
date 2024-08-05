package com.data_structure;

import com.data_structure.linear.queue.PriorityQueueWithArray;
import com.data_structure.non_linear.Trees.heaps.Heap;
import com.data_structure.non_linear.Trees.heaps.MaxHeap;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    int[] numbers = {5, 3, 10, 1, 4, 2};
    Heap heap = new Heap();

    // Sort Exercise
    for (int number : numbers) {
      heap.insert(number); // O(log n)
    }
    // asc
    for (int i = numbers.length - 1; i >= 0; i--) {
      numbers[i] = heap.remove(); // O(log n)
    }
    System.out.println(Arrays.toString(numbers));

    var queue = new PriorityQueueWithArray();
    queue.insert(30); // O(n)
    queue.insert(20); // O(n)
    queue.insert(10); // O(n)
    System.out.println(queue);
    queue.remove(); // O(1)

    int[] numbersArr = {5, 3, 8, 4, 1, 2};
    MaxHeap.heapify(numbersArr);
    System.out.println(Arrays.toString(numbersArr));

    // Exercise Kth largest number
    System.out.println(MaxHeap.getKthLargest(numbersArr, 2));
  }
}