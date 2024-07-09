package com.data_structure.non_linear.Trees;

public class Tree {

  private Node root;

  public void insert(int value) {
    Node node = new Node(value);

    if (isEmpty()) {
      root = node;
      return;
    }

    var current = root;
    while (true) {
      if (value < current.value) {
        if (current.leftChild == null) {
          current.leftChild = node;
          break;
        }
        current = current.leftChild;
      } else {
        if (current.rightChild == null) {
          current.rightChild = node;
          break;
        }
        current = current.rightChild;
      }
    }
  }

  public void traversePreOrder() {
    traversePreOrder(root);
  }

  private void traversePreOrder(Node root) {
    if (root == null) {
      return;
    }

    System.out.println(root.value);
    traversePreOrder(root.leftChild);
    traversePreOrder(root.rightChild);
  }

  public void traverseInOrder() {
    traverseInOrder(root);
  }

  private void traverseInOrder(Node root) {
    if (root == null) {
      return;
    }

    traverseInOrder(root.leftChild);
    System.out.println(root.value);
    traverseInOrder(root.rightChild);
  }

  public void traversePostOrder() {
    traversePostOrder(root);
  }

  private void traversePostOrder(Node root) {
    if (root == null) {
      return;
    }

    traverseInOrder(root.leftChild);
    traverseInOrder(root.rightChild);
    System.out.println(root.value);
  }

  public boolean find(int value) {
    var current = root;
    while (current != null) {
      if (value < current.value) {
        current = current.leftChild;
      } else if (value > current.value) {
        current = current.rightChild;
      } else {
        return true;
      }
    }

    return false;
  }

  public int height() {
    return height(root);
  }

  private int height(Node root) {
    if (root == null) {
      return -1;
    }

    if (isLeaf(root)) {
      return 0;
    }

    return 1 + Math.max(height(root.leftChild), height(root.rightChild));
  }


  //  findMinInBST method for BST - binary search tree O(log n)
  public int findMinInBST() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    var current = root;
    var last = current;

    while (current != null) {
      last = current;
      current = current.leftChild;
    }

    return last.value;
  }

  public int findMinInBT() {
    return findMinInBT(root);
  }

  //  findMinInBT method for binary tree O(n)
  private int findMinInBT(Node root) {
    if (isLeaf(root)) {
      return root.value;
    }
    var left = findMinInBT(root.leftChild);
    var right = findMinInBT(root.rightChild);

    return Math.min(Math.min(left, right), root.value);
  }

  // Exercise 1 - Tree Equality
  public boolean equals(Tree other) {
    if (other == null) {
      return false;
    }

    return equals(root, other.root);
  }

  private boolean equals(Node first, Node second) {
    if (first == null && second == null) {
      return true;
    }

    if (first != null && second != null) {
      return first.value == second.value
          && equals(first.leftChild, second.leftChild)
          && equals(first.rightChild, second.rightChild);
    }
    return false;
  }

  // Exercise 2 - Validate BST
  public boolean isValidBST() {
    return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private boolean isValidBST(Node root, int min, int max) {
    if (root == null) {
      return true;
    }

    if (root.value < min || root.value > max) {
      return false;
    }

    return isValidBST(root.leftChild, min, root.value - 1)
        && isValidBST(root.rightChild, root.value + 1, max);
  }


  private boolean isEmpty() {
    return root == null;
  }

  private boolean isLeaf(Node node) {
    return node.leftChild == null && node.rightChild == null;
  }

  private class Node {

    private Node leftChild;
    private Node rightChild;
    private int value;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node=" + value;
    }
  }
}