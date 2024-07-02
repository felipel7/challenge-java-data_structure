package com.data_structure.linear.hash_tables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {

  public char findFirstNonRepeatingChar(String string) {
    Map<Character, Integer> map = new HashMap<>();
    var chars = string.toCharArray();

    for (char ch : chars) {
      var count = map.containsKey(ch) ? map.get(ch) : 0;
      map.put(ch, count + 1);
    }

    for (char ch : chars) {
      if (map.get(ch) == 1) {
        return ch;
      }
    }

    return Character.MIN_VALUE;
  }

  public char findFirstRepeatedChar(String string) {
    Set<Character> set = new HashSet<>();

    for (char ch : string.toCharArray()) {
      if (set.contains(ch)) {
        return ch;
      }

      set.add(ch);
    }

    return Character.MIN_VALUE;
  }
}
