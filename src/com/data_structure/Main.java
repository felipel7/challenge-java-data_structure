package com.data_structure;

import com.data_structure.hashtables.CharFinder;
import com.data_structure.hashtables.HashTable;

public class Main {

  public static void main(String[] args) {
    String string = "a green apple";
    CharFinder finder = new CharFinder();
    System.out.println(finder.findFirstNonRepeatingChar(string));

    System.out.println(finder.findFirstRepeatedChar(string));
    HashTable table = new HashTable();
    table.put(6, "A");
    table.put(8, "B");
    table.put(11, "C");
    table.put(6, "A*");
    table.remove(6);
    System.out.println("Finished");
  }
}
