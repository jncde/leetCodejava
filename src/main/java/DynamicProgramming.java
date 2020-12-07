public class DynamicProgramming {

  public static void printDPTable ( boolean[][] dp,int _1DLen,int _2DLen) {

    Boolean[][] dpObj=new Boolean[_1DLen][_2DLen];
    for (int i = 0; i < _1DLen; i++) {
      for (int j = 0; j <_2DLen ; j++) {
        dpObj[i][j]=dp[i][j];
      }
    }


    printDPTableWithNull (dpObj,_1DLen,_2DLen);
  }


  public static void printDPTableWithNull ( Boolean[][] dp,int _1DLen,int _2DLen) {
    String columSpace="  ";
    int firstColMargin=4;
    //asumation dp.length==dp[0].length
    for(int row=0;row<_1DLen;row++){

      if(row==0){
        StringBuilder jHeader=new StringBuilder ();
        jHeader.append ("i\\j    ".substring (0,firstColMargin));
        for(int c=0;c<_2DLen;c++){
          jHeader.append (c+columSpace);
        }
        System.out.println (jHeader.toString ());
      }


      StringBuilder sb=new StringBuilder ();
      for(int c=0;c<_2DLen;c++) {
        if(c==0){
          sb.append ((row+"     ").substring (0,firstColMargin));
        }
        if(dp[row][c]==null){
          sb.append ('N');
        }else{

          Object o = dp[row][c];
          if(o instanceof Boolean){
            sb.append ((boolean)dp[row][c]==true?1:0);
          }else {
            sb.append (o);
          }
        }
        sb.append (columSpace);
      }
      System.out.println (sb.toString ());
    }
    System.out.println ("------------------------------");
  }






}
