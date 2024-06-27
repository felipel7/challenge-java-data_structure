package com.data_structure;

import com.data_structure.stack.Expression;
import com.data_structure.stack.Stack;
import com.data_structure.stack.StringReverser;

public class Main {

  public static void main(String[] args) {

    String stringToBeReverse = "abc";
    var stringReverser = new StringReverser();
    var reversed = stringReverser.reverse(stringToBeReverse);
    System.out.println(reversed);

    String string = "(({[<>]}))";
    Expression expression = new Expression();
    var result = expression.isBalanced(string);
    System.out.println(result);

    Stack stack = new Stack();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.pop();
    System.out.println(stack);
    System.out.println(stack.peek());
  }
}
