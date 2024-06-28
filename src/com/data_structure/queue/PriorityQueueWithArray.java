package com.data_structure.queue;

import java.util.Arrays;

public class PriorityQueueWithArray {

  int count = 0;
  private int[] items = new int[5];

  public void insert(int item) {
    if (isFull()) {
      throw new IllegalStateException();
    }

    int index = shiftItemsToInsert(item);
    items[index] = item;
    count++;
  }

  public int remove() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    return items[--count];
  }

  private int shiftItemsToInsert(int item) {
    int i;
    for (i = count - 1; i >= 0; i--) {
      if (items[i] > item) {
        items[i + 1] = items[i];
      } else {
        break;
      }
    }

    return i + 1;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public boolean isFull() {
    return count == items.length;
  }

  @Override
  public String toString() {
    var array = Arrays.copyOfRange(items, 0, count);
    return Arrays.toString(array);
  }
}
