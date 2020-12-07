import org.junit.Assert;
import org.junit.Test;

/**
 * use deep first  search
 */
public class Backtracking_eightQueen {

  boolean debug=true;
  int max ;
  int[] q;
  int solution=0;

  public void findResult(int queenSize) {
    max=queenSize;
    q=new int[queenSize];
    solution=0;
    backTracking (0);
  }



  public void backTracking(int n){

    if(n==max){
      print("solution",n);
      solution++;
      return;
    }

    for (int j = 0; j <max ; j++) {
      q[n]=j;
      if(isValid(n,j)){
        if(debug){
          print ("valid part solution n = "+n,n+1);
        }
          backTracking (n+1);
      }else{
        if(debug){
          print ("!!invalid part solution n = "+n,n+1);
        }
      }

    }


  }

  private void print (String title,int n) {
    System.out.println (title+": ");
    for (int i = 0; i < n; i++) {
      System.out.print (q[i]+" ");
    }
    System.out.println ("");

  }

  private boolean isValid (int newRow,int newCol) {
    if(newRow==0){
      return true;
    }

    for (int row = 0; row < newRow; row++) {
      Integer exstedCol = q[row];
      if(exstedCol == newCol || exstedCol+row==newCol+newRow ||exstedCol-newCol==row-newRow)
            return false;
    }
    return true;
  }

  /**
   * no recursive, tfs
   */
  public void queen () {
    int row = 0, col = 0;
    while (row < max) {
      while (col < max) {
        if (isValid (row, col)) {
          q[row] = col;
          col = 0;
          break;
        } else {
          ++col;
        }
      }
      if (col == max)//q[row]==-1
      {
        if (row == 0)
          break;
        else {
          --row;
          col = q[row] + 1;
          q[row] = -1;  //把上一行皇后的位置清除，重新探测
          continue;
        }
      }
      if (row == max - 1) {
        solution++;
        if (solution == 1)
          print ("", max);
        col = q[row] + 1;
        q[row] = -1;
        continue;
      }
      ++row;
    }
  }


  @Test
  public void test() {
//    findResult (4);
//    Assert.assertEquals (2,solution);

    findResult (8);
    Assert.assertEquals (92,solution);
  }

  @Test
  public void testNoRecursive() {
    int queenSize=8;
    max=queenSize;
    q=new int[queenSize];
    solution=0;
    for(int i=0;i<max;i++)//初始化
      q[i]=-1;
    queen();
    System.out.println(solution);
  }


}
