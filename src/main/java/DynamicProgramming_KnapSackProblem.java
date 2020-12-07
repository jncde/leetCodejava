import org.junit.Test;

/**
 *
 *
 * <pre>
 *
 *
 *
 *   reference:
 *
 *   explain: https://zhuanlan.zhihu.com/p/30959069
 *   source code: https://blog.csdn.net/lanyu_01/article/details/79815801
 * </pre>
 *
 *
 */
public class DynamicProgramming_KnapSackProblem {

  int sackMaxWeight;
  int bigestValue;
  int itemCounts;
  int[] weights;
  int[] values;
  int[] x;
  int[] bestX;
  boolean debug=true;
  int pathsCount;
  int[][] dp;



  public DynamicProgramming_KnapSackProblem (){
    sackMaxWeight = 11;
    itemCounts=5;
//    weights= new int[] {1, 2, 5, 6, 7};
//    values=new int[] {1, 6, 18, 22, 28};

    //different sequence of weights and values will not change the final result
    weights= new int[] {7, 2, 5, 6, 1};
    values=new int[] {28, 6, 18, 22, 1};
//    weights= new int[] {1, 2, 5};
//    values=new int[] {1, 6, 18};
    dp=new int[itemCounts+1][sackMaxWeight+1];
  }

  public String dp(){

    //if weight is 0, than there is no items in bag

    for (int i = 0; i < itemCounts+1; i++) {
      int bagWeight=0;
      dp[i][bagWeight]=0;
    }

    // if items in bag is 0 (:= no item), then the state is 0
    for (int w = 0; w < sackMaxWeight+1; w++) {
      int item=0;
      dp[item][w]=0;
    }


    // fill the dp tables
    for (int i = 1; i < itemCounts+1; i++) {
      for (int w = 1; w < sackMaxWeight+1; w++) {
           if(ithWeight(i)>w) {
             //if the i-th is weight than bagWeight, then the i-th will not be taken, then dp[i][w] is the value of dp for  i-1 item(the first fall)
             //如果第i件物品的重量大于背包容量j,则不装入背包
             //由于weight和value数组下标都是从0开始,故注意第i个物品的重量为weight[i-1],价值为value[i-1]
              dp[i][w]=dp[i-1][w];
            }else{
                //  if i-th is not bigger than bagweight, then
                // first fall: without i: dp[i-1][w]
                // second fall: with i: dp[i-1][w-ithWeight(i)]+ithValue(i)
                dp[i][w]=Math.max (dp[i-1][w],dp[i-1][w-ithWeight(i)]+ithValue(i));
            }

        printDPTableWithNull (dp);

      }
    }

    // last step, return the selected items
    //则容量为V的背包能够装入物品的最大值为
    int maxValue = dp[itemCounts][sackMaxWeight];
    //逆推找出装入背包的所有商品的编号
    int j=sackMaxWeight;
    String numStr="";
    for(int i=itemCounts;i>0;i--){
      //若果dp[i][j]>dp[i-1][j],这说明第i件物品是放入背包的
      if(dp[i][j]>dp[i-1][j]){
        numStr = i+" "+numStr;
        j=j-ithWeight(i);
      }
      if(j==0)
        break;
    }
    return numStr;

  }

  public int ithWeight(int i) {
      return weights[i-1];
  }
  public int ithValue(int i) {
    return values[i-1];
  }



  @Test
  public void test() {
    String selecteItems=dp();
    System.out.println (selecteItems);
  }

  private void printBest () {
    System.out.println ("has tried solution count: "+pathsCount);
    System.out.println ("best value: "+bigestValue);
    for (int i = 0; i < itemCounts; i++) {
        if(bestX[i]==1) {
          System.out.print (" "+weights[i]+" ");
        }else{
          System.out.print (" null ");
        }
      }
  }


  public static void printDPTableWithNull (int[][] dp) {
    String valuePadding="  ";
    String columSpace="     ";
    String headercolumSpace="      ";
    int firstColMargin=4;
    int _1DLen = dp.length;
    int _2DLen = dp[0].length;
    //asumation dp.length==dp[0].length
    for(int row=0;row<_1DLen;row++){

      if(row==0){
        StringBuilder jHeader=new StringBuilder ();
        jHeader.append ("i\\j    ".substring (0,firstColMargin));
        for(int c=0;c<_2DLen;c++){
          jHeader.append (c+headercolumSpace);
        }
        System.out.println (jHeader.toString ());
      }


      StringBuilder sb=new StringBuilder ();
      for(int c=0;c<_2DLen;c++) {
        if(c==0){
          sb.append ((row+"     ").substring (0,firstColMargin));
        }
        String i = valuePadding+String.valueOf (dp[row][c]);
        sb.append (i.substring (i.length ()-2));

        sb.append (columSpace);
      }
      System.out.println (sb.toString ());
    }
    System.out.println ("------------------------------");
  }

}
