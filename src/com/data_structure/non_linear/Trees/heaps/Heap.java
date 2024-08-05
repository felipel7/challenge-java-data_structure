package com.data_structure.non_linear.Trees.heaps;

public class Heap {

  private int[] items = new int[10];
  private int size;

  public void insert(int value) {
    if (isFull()) {
      throw new IllegalStateException();
    }

    items[size++] = value;

    bubbleUp();
  }

  public int remove() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }

    var root = items[0];
    items[0] = items[--size];

    bubbleDown();

    return root;
  }

  public boolean isFull() {
    return size == items.length;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  private boolean isValidParent(int index) {
    if (!hasLeftChild(index)) {
      return true;
    }

    var isValid = items[index] >= leftChild(index);
    if (hasRightChild(index)) {
      isValid &= items[index] >= rightChildIndex(index);
    }

    return isValid;
  }

  private int largerChildIndex(int index) {
    if (!hasLeftChild(index)) {
      return index;
    }

    if (!hasRightChild(index)) {
      return leftChild(index);
    }

    return (leftChild(index) > rightChild(index)) ? leftChildIndex(index) : rightChildIndex(index);
  }

  private int leftChild(int index) {
    return items[leftChildIndex(index)];
  }

  private boolean hasLeftChild(int index) {
    return leftChildIndex(index) <= size;
  }

  private int leftChildIndex(int index) {
    return index * 2 + 1;
  }

  private int rightChildIndex(int index) {
    return index * 2 + 2;
  }

  private int rightChild(int index) {
    return items[rightChildIndex(index)];
  }

  private boolean hasRightChild(int index) {
    return rightChildIndex(index) <= size;
  }

  private int parent(int index) {
    return (index - 1) / 2;
  }

  private void swap(int first, int second) {
    var temporary = items[first];
    items[first] = items[second];
    items[second] = temporary;
  }

  private void bubbleUp() {
    var index = size - 1;
    while (index > 0 && items[index] > items[parent(index)]) {
      swap(index, parent(index));
      index = parent(index);
    }
  }

  private void bubbleDown() {
    var index = 0;
    while (index <= size && !isValidParent(index)) {
      var largerChildIndex = largerChildIndex(index);
      swap(index, largerChildIndex);
      index = largerChildIndex;
    }
  }
}

/*
 Formulas:
   left = parent * 2 + 1
   right = parent * 2 + 2
   parent = (index - 1) / 2
*/
