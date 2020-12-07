package _22Parenthesis;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *
 * different between backTracking and dps
 *
 * 深度优先遍历通过「回溯」操作，实现了全局使用 "一份" 状态变量的效果。
 *
 *
 * "一份" 状态变量: stringBuild , not String (deepSearch use String)
 * </pre>
 *
 *
 *
 */
public class backtracking {


    public List<String> generateParenthesis_backTracking (int n) {
      List<String> ans = new ArrayList ();
      backtrack(ans, new StringBuilder(), 0, 0, n);
      return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
      System.out.println (ans.toString ());
      if (cur.length() == max * 2) {
        ans.add(cur.toString());
        return;
      }

      if (open < max) {
        cur.append('(');
        backtrack(ans, cur, open+1, close, max);
        cur.deleteCharAt(cur.length() - 1);
      }
      if (close < open) {
        cur.append(')');
        backtrack(ans, cur, open, close+1, max);
        cur.deleteCharAt(cur.length() - 1);
      }
    }



    @Test
    public void test() {
      List<String> resultes = generateParenthesis_backTracking (3);
      //out put: [((())), (()()), (())(), ()(())]
    }



}
