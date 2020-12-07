import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 *
 * solition1:  dynamic programming
 * solution2:  center spread
 *</pre>
 */
public class _5LongestPalindromicSubstring {

  Map<String,String> datas =new HashMap<> ();
  boolean printDp=true;

  @Before
  public void init(){
    datas.put ("ababc","aba");
    datas.put ("absdacadbca","dacad");
  }

   @Test
   public void testCenterSpread(){

    for(Map.Entry<String,String> entry : datas.entrySet () ){
      Assert.assertEquals (entry.getValue (), centerSpreadSolution (entry.getKey ()));
    }

   }


  @Test
  public void testDynamicProgramming(){

    for(Map.Entry<String,String> entry : datas.entrySet () ){
      Assert.assertEquals (entry.getValue (), dpSolution (entry.getKey ()));
    }

  }

  private String dpSolution (String s) {

    int len=s.length ();

    if(len<2) return s;

    char[] cs = s.toCharArray ();
    int maxLen=1;
    int start=0;
    boolean[][] dp=new boolean[len][len];

    // 初始化
    for (int i = 0; i < len; i++) {
      dp[i][i] = true;
    }



    for(int j=1;j<len;j++){
      for(int i=j-1;i>=0;i--){
        if(cs[i]==cs[j]) {
          if (j - i < 3) {
            dp[i][j] = true;
          } else {
            dp[i][j] = dp[i + 1][j - 1];
          }
        }else{
          dp[i][j]=false;
        }
        if(dp[i][j]&&j-i+1>maxLen){
          maxLen=j-i+1;
          start=i;
        }

      }
    }

    //debug info
    if(printDp)  DynamicProgramming.printDPTable (dp,len,len);

    return s.substring (start,start+maxLen);
  }



  public String centerSpreadSolution (String s) {


     if(s.length ()<2) return s;

     int maxLen=1;
     String res=s.substring (0,1);
     int len=s.length ();
    char[] chars = s.toCharArray ();

    for(int i=1;i<len-1;i++){
       int evenLeftSpread=getMaxCenterSpread(chars,i,i);
       int oddLeftSpread=getMaxCenterSpread(chars,i,i+1);
       int spreadStart,spreadEnd;
       if(evenLeftSpread>oddLeftSpread){
         spreadStart=i-evenLeftSpread;
         //right is the same
         spreadEnd=i+evenLeftSpread;
       }else{
         spreadStart=i-oddLeftSpread;
         spreadEnd=i+1+evenLeftSpread;
       }

       if(spreadEnd-spreadStart+1>maxLen){
         maxLen=spreadEnd-spreadStart+1;
         res=s.substring (spreadStart,spreadEnd+1);
       }


     }


    return res;

  }

  private int getMaxCenterSpread (char[] s, int left, int right) {
    int len=s.length;
    int leftStart=left;
     while(left>=0&&right< len){
       if(s[left]==s[right]){
         left--;
         right++;
       }else{
         break;
       }
     }
     return leftStart-(left+1);

  }
}