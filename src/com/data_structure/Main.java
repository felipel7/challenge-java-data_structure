package com.data_structure;

import com.data_structure.non_linear.Trees.Tries.Trie;

public class Main {

  public static void main(String[] args) {
    var trie = new Trie();
    trie.insert("cat");
    trie.insert("can");

    System.out.println(trie.contains("cat"));
    System.out.println(trie.contains("cats"));

    trie.traverse();

    trie.remove("cat");
    System.out.println(trie.contains("cat"));
  }
}