package com.data_structure.non_linear.Trees.AVL;

public class AVLTree {

  private AVLNode root;

  public void insert(int value) {
    root = insert(value, root);
  }

  private AVLNode insert(int value, AVLNode root) {
    if (root == null) {
      return new AVLNode(value);
    }

    if (value < root.value) {
      root.leftChild = insert(value, root.leftChild);
    } else {
      root.rightChild = insert(value, root.rightChild);
    }

    setHeight(root);

    return balance(root);
  }

  private AVLNode balance(AVLNode node) {
    if (isLeftHeavy(node)) {
      if (balanceFactor(node.leftChild) < 0) {
        node.leftChild = leftRotate(node.leftChild);
      }
      return rightRotate(node);
    } else if (isRightHeavy(node)) {
      if (balanceFactor(node.rightChild) > 0) {
        node.rightChild = rightRotate(node.rightChild);
      }
      return leftRotate(node);
    }
    return node;
  }

  private AVLNode leftRotate(AVLNode root) {
    var newRoot = root.rightChild;

    // rotation
    root.rightChild = newRoot.leftChild;
    newRoot.leftChild = root;

    setHeight(root);
    setHeight(newRoot);

    return newRoot;
  }

  private AVLNode rightRotate(AVLNode root) {
    var newRoot = root.leftChild;

    root.leftChild = newRoot.rightChild;
    newRoot.rightChild = root;

    setHeight(root);
    setHeight(newRoot);

    return newRoot;
  }

  private int height(AVLNode node) {
    return (node == null) ? -1 : node.height;
  }

  private void setHeight(AVLNode node) {
    node.height = Math.max(height(root.leftChild), height(root.rightChild)) + 1;
  }

  private boolean isLeftHeavy(AVLNode node) {
    return balanceFactor(node) > 1;
  }

  private boolean isRightHeavy(AVLNode node) {
    return balanceFactor(node) < -1;
  }

  private int balanceFactor(AVLNode node) {
    return (node == null) ? 0 : height(node.leftChild) - height(node.rightChild);
  }

  private class AVLNode {

    private AVLNode leftChild;
    private AVLNode rightChild;
    private int value;
    private int height;

    public AVLNode(int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "AVLNode=" + value;
    }
  }
}
