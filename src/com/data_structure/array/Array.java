package com.data_structure.array;

public class Array {
    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void addItem(int item) {
        if (items.length == count) {
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++)
                newItems[i] = items[i];

            items = newItems;
        }

        items[count++] = item;
    }

    public void removeItemAt(int index) { // O(n)
      if (index < 0 || index >= count)
          throw new IllegalArgumentException();

      for (int i = index; i < count - 1; i++)
          items[i] = items[i + 1];

      count--;
    }

    public int indexOf(int item) { // O(n)
        for (int i = 0; i < count; i++)
            if (items[i] == item)
                return i;

        return -1;
    }

    public void print() {
        if (count == 0) {
            System.out.println("Array is empty.");
            return;
        }

        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }
}
