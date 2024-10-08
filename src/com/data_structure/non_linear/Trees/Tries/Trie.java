package com.data_structure.non_linear.Trees.Tries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Trie {

  private Node root = new Node(' ');

  public void insert(String word) {
    var current = root;
    for (var ch : word.toCharArray()) {
      if (!current.hasChild(ch)) {
        current.addChild(ch);
      }
      current = current.getChild(ch);
    }
    current.isEndOfWord = true;
  }

  public boolean contains(String word) {
    if (word == null) {
      return false;
    }

    var current = root;
    for (var ch : word.toCharArray()) {
      if (!current.hasChild(ch)) {
        return false;
      }
      current = current.getChild(ch);
    }
    return current.isEndOfWord;
  }

  public void traverse() {
    traverse(root);
  }

  private void traverse(Node root) {
    // Pre-order
    System.out.println(root.value);

    for (var ch : root.getChildren()) {
      traverse(ch);
    }

    // Post-order
    System.out.println(root.value);
  }

  public void remove(String word) {
    if (word == null) {
      return;
    }

    remove(root, word, 0);
  }

  private void remove(Node root, String word, int index) {

    if (index == word.length()) {
      root.isEndOfWord = false;
      return;
    }

    var ch = word.charAt(index);
    var child = root.getChild(ch);
    if (child == null) {
      return;
    }

    remove(child, word, index + 1);

    if (!child.hasChildren() && !child.isEndOfWord) {
      root.removeChild(ch);
    }
  }

  public List<String> findWords(String prefix) {
    List<String> words = new ArrayList<>();
    var lastNode = findLastNodeOf(prefix);
    findWords(lastNode, prefix, words);

    return words;
  }

  private void findWords(Node root, String prefix, List<String> words) {
    if (root == null) {
      return;
    }

    if (root.isEndOfWord) {
      words.add(prefix);
    }

    for (var child : root.getChildren()) {
      findWords(child, prefix + child.value, words);
    }
  }

  private Node findLastNodeOf(String prefix) {
    if (prefix == null) {
      return null;
    }

    var current = root;
    for (var ch : prefix.toCharArray()) {
      var child = current.getChild(ch);
      if (child == null) {
        return null;
      }
      current = child;
    }

    return current;
  }

  private class Node {

    private char value;
    private HashMap<Character, Node> children = new HashMap<>();
    private boolean isEndOfWord;

    public Node(char value) {
      this.value = value;
    }

    private boolean hasChild(char ch) {
      return children.containsKey(ch);
    }

    private boolean hasChildren() {
      return !children.isEmpty();
    }

    private void addChild(char ch) {
      children.put(ch, new Node(ch));
    }

    private Node getChild(char ch) {
      return children.get(ch);
    }

    private Node[] getChildren() {
      return children.values().toArray(new Node[0]);
    }

    private void removeChild(char ch) {
      children.remove(ch);
    }

    @Override
    public String toString() {
      return "value=" + value;
    }
  }
}
