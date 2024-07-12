package com.data_structure;

import com.data_structure.non_linear.Trees.Tree;

public class Main {

  public static void main(String[] args) {
    Tree binarySearchTree = new Tree();
    binarySearchTree.insert(7);
    binarySearchTree.insert(4);
    binarySearchTree.insert(1);
    binarySearchTree.insert(6);
    binarySearchTree.insert(9);
    binarySearchTree.insert(8);
    binarySearchTree.insert(10);
    System.out.println("Use breakpoint in this line for debug and test implementation");

    System.out.println(binarySearchTree.find(11));

    System.out.println("\nPre order: ");
    binarySearchTree.traversePreOrder();

    System.out.println("\nIn order: ");
    binarySearchTree.traverseInOrder();

    System.out.println("\nPost order: ");
    binarySearchTree.traversePostOrder();

    System.out.println("\nTree height: " + binarySearchTree.height());

    System.out.println("\nMin value in the tree: " + binarySearchTree.findMinInBST());

    Tree other = new Tree();
    other.insert(7);
    other.insert(4);
    other.insert(1);
    other.insert(6);
    other.insert(9);
    other.insert(8);
    other.insert(10);

    System.out.println("\nAre the trees equal? " + binarySearchTree.equals(other));

    System.out.println("\nIs the BST valid? " + binarySearchTree.isValidBST());

    System.out.print("\nNodes at distance 2: " + binarySearchTree.getNodesAtDistance(2));

    System.out.println("\nTraverse Level Order:");
    binarySearchTree.traverseLevelOrder();
  }
}
