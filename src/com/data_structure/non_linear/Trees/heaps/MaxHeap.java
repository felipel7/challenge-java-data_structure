package com.data_structure.non_linear.Trees.heaps;

public class MaxHeap {

  public static void heapify(int[] numbersArr) {
    int lastParentIndex = numbersArr.length / 2 - 1;
    for (int i = lastParentIndex; i >= 0; i--) {
      heapify(numbersArr, i);
    }
  }

  private static void heapify(int[] numbersArr, int index) {
    var largerIndex = index;

    var leftIndex = index * 2 + 1;
    if (leftIndex < numbersArr.length && numbersArr[leftIndex] > numbersArr[largerIndex]) {
      largerIndex = leftIndex;
    }

    var rightIndex = index * 2 + 2;
    if (rightIndex < numbersArr.length && numbersArr[rightIndex] > numbersArr[largerIndex]) {
      largerIndex = rightIndex;
    }

    if (index == largerIndex) {
      return;
    }

    swap(numbersArr, index, largerIndex);
    heapify(numbersArr, largerIndex);
  }

  private static void swap(int[] numbersArr, int first, int second) {
    var temporary = numbersArr[first];
    numbersArr[first] = numbersArr[second];
    numbersArr[second] = temporary;
  }

  public static int getKthLargest(int[] numbersArr, int k) {
    if (k < 1 || k > numbersArr.length) {
      throw new IllegalArgumentException();
    }

    var heap = new Heap();
    for (var number : numbersArr) {
      heap.insert(number);
    }

    for (int i = 0; i < k - 1; i++) {
      heap.remove();
    }

    return heap.max();
  }
}
