import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class _17PhotoNumbers {

  List<String> res        = new ArrayList<String> ();
  String[]     lettersMap = {"", "",     //1
                             "abc",  //2
                             "def",  //3
                             "ghi",  //4
                             "jkl",  //5
                             "mno",  //6
                             "pqrs", //7
                             "tuv",  //8
                             "wxyz"  //9
  };

  public List<String> letterCombinationsWithRecursiv (String digits) {

    if (digits == null || digits.length () == 0) {
      return res;
    }

    findCombination (digits, 0, "");

    return res;
  }

  private void findCombination (String digits, int i, String s) {

    if (digits.length () == i) {
      res.add (s);
      return;
    }

    char c = digits.charAt (i);
    String letters = lettersMap[c - '0'];

    for (int j = 0; j < letters.length (); j++) {
      findCombination (digits, i + 1, s + letters.charAt (j));
    }

  }

  @Test
  public void test () {

    String digs = "2435";

    List<String> results = this.letterCombinationsWithRecursiv (digs);

    assert results.size () == 81;

    System.out.println (results.toString ());

  }

}
