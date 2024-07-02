package com.data_structure.linear.array;

public class Array {

  private int[] items;
  private int count;

  public Array(int length) {
    items = new int[length];
  }

  public void addItem(int item) {
    resizeIfRequired();

    items[count++] = item;
  }

  public void removeItemAt(int index) { // O(n)
    if (index < 0 || index >= count) {
      throw new IllegalArgumentException();
    }

    for (int i = index; i < count - 1; i++) {
      items[i] = items[i + 1];
    }

    count--;
  }

  public int indexOf(int item) { // O(n)
    for (int i = 0; i < count; i++) {
      if (items[i] == item) {
        return i;
      }
    }

    return -1;
  }

  public void print() {
    if (count == 0) {
      System.out.println("Array is empty.");
      return;
    }

    for (int i = 0; i < count; i++) {
      System.out.println(items[i]);
    }
  }

  public int max() { // O(n)
    int max = 0;
    for (int item : items) {
      if (item > max) {
        max = item;
      }
    }

    return max;
  }

  public void reverse() {
    int[] newItems = new int[count];

    for (int i = 0; i < count; i++) {
      newItems[i] = items[count - i - 1];
    }

    items = newItems;
  }

  public Array intersect(Array other) {
    var intersection = new Array(count);

    for (int item : items) {
      if (other.indexOf(item) >= 0) {
        intersection.addItem(item);
      }
    }

    return intersection;
  }

  public void insertAt(int item, int index) {
    if (index < 0 || index > count) {
      throw new IllegalArgumentException();
    }

    resizeIfRequired();

    for (int i = count - 1; i >= index; i--) {
      items[i + 1] = items[i];
    }

    items[index] = item;
    count++;
  }

  private void resizeIfRequired() {
    if (items.length == count) {
      int[] newItems = new int[count * 2];

      for (int index = 0; index < count; index++) {
        newItems[index] = items[index];
      }

      items = newItems;
    }
  }
}
