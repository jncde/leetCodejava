package _22Parenthesis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class breadthFirstSearch {

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

  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      return res;
    }
    Queue<Node> queue = new LinkedList<> ();
    queue.offer(new Node("", n, n));

    int i=1;

    while (!queue.isEmpty()) {

//      System.out.println ("Queue:"+queue.stream ().map (n2->n2.toString ()).collect(Collectors.joining()));

      Node curNode = queue.poll();
      System.out.println ("pull node "+i+++" : "+curNode.toString ());
      if (curNode.left == 0 && curNode.right == 0) {
        System.out.println ("leef node: "+curNode.toString ());
        res.add(curNode.res);
      }
      if (curNode.left > 0) {
        queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
      }
      if (curNode.right > 0 && curNode.left < curNode.right) {
        queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
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
