package _22Parenthesis;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class deepFirstSearch_Stack {

  class Node {
    /**
     * 当前得到的字符串
     */
    private String res;
    /**
     * 剩余左括号数量
     */
    private int left;
    /**
     * 剩余右括号数量
     */
    private int right;

    public Node(String str, int left, int right) {
      this.res = str;
      this.left = left;
      this.right = right;
    }
    @Override
    public String toString () {
      return "Node{" + "res='" + res + '\'' + ", left=" + left + ", right=" + right + '}';
    }

  }

  // 注意：这是深度优先遍历

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }

    // 查看了 Stack 源码，官方推荐使用 Deque 对象，
    // 注意：只使用栈相关的接口，即只使用 `addLast()` 和 `removeLast()`
    Deque<Node> stack = new ArrayDeque<> ();
    stack.addLast(new Node("", n, n));
    while (!stack.isEmpty()) {

      Node curNode = stack.removeLast();
      System.out.println ("get last   : "+curNode.toString ());
      if (curNode.left == 0 && curNode.right == 0) {
        System.out.println ("pull node  : "+curNode.toString ());
        res.add(curNode.res);
      }
      if (curNode.left > 0) {
        stack.addLast(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
      }
      if (curNode.right > 0 && curNode.left < curNode.right) {
        stack.addLast(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
      }
    }
    return res;
  }



    @Test
    public void test() {
      List<String> resultes = generateParenthesis (3);
      //out put: [((())), (()()), (())(), ()(())]
    }



}
