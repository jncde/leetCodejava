import org.junit.Assert;
import org.junit.Test;

public class _10RegularExpressionMatching {


  @Test
  public void testRegularEx() {
    String s="abcde";
    String pattern="abc.*";

    Assert.assertTrue (isMatch (s,pattern));


  }

  @Test
  public void testRegularEx2() {

    String s="abcdd";
    String pattern=".*cd*";

    Assert.assertTrue (isMatch (s,pattern));

  }



  public boolean  isMatch(String s, String p) {
    int m = s.length();
    int n = p.length();

    Boolean[][] f = new Boolean[m + 1][n + 1];
    f[0][0] = true;
    for (int i = 0; i <= m; ++i) {
      for (int j = 1; j <= n; ++j) {
        if (p.charAt(j - 1) == '*') {
          f[i][j] = f[i][j - 2];
          if (matches(s, p, i, j - 1)) {
            // original, something wrong???:           f[i][j] = f[i][j] || f[i - 1][j];
            f[i][j] = f[i - 1][j];
          }
        }
        else {
          if (matches(s, p, i, j)) {
            f[i][j] = f[i - 1][j - 1];
          }else{
            f[i][j]=false;
          }
        }

        System.out.println ("i: "+i+" j: "+j);
        DynamicProgramming.printDPTableWithNull (f,m+1,n+1);
      }
    }
    return f[m][n];

  }


  public boolean matches(String s, String p, int i, int j) {
    if (i == 0) {
      return false;
    }
    if (p.charAt(j - 1) == '.') {
      return true;
    }
    return s.charAt(i - 1) == p.charAt(j - 1);
  }



}
