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

    if (root.leftChild == null && root.rightChild == null) {
      return 0;
    }

    return 1 + Math.max(height(root.leftChild), height(root.rightChild));
  }

  private boolean isEmpty() {
    return root == null;
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