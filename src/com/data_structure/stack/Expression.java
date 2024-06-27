package com.data_structure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

  private final List<Character> leftBracket = Arrays.asList('(', '[', '<', '{');
  private final List<Character> rightBracket = Arrays.asList(')', ']', '>', '}');

  public Boolean isBalanced(String expression) {
    Stack<Character> stack = new Stack<>();

    for (char ch : expression.toCharArray()) {
      if (isLeftBracket(ch)) {
        stack.push(ch);
      }

      if (isRightBracket(ch)) {
        if (stack.isEmpty()) {
          return false;
        }

        var left = stack.pop();
        if (!bracketsMatch(left, ch)) {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }

  private boolean isLeftBracket(char ch) {
    return leftBracket.contains(ch);
  }

  private boolean isRightBracket(char ch) {
    return rightBracket.contains(ch);
  }

  private boolean bracketsMatch(char left, char right) {
    return leftBracket.indexOf(left) == rightBracket.indexOf(right);
  }
}
