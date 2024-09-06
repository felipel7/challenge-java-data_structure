package com.data_structure;

import com.data_structure.non_linear.Trees.Tries.Trie;

public class Main {

  public static void main(String[] args) {
    var trie = new Trie();
    trie.insert("cat");
    trie.insert("can");
    trie.insert("car");

    System.out.println(trie.contains("cat"));
    System.out.println(trie.contains("cats"));

    trie.traverse();

    trie.remove("cat");
    System.out.println(trie.contains("cat"));

    var words = trie.findWords("ca");
    System.out.println(words);
  }
}