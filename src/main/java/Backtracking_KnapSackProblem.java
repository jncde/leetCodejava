import org.junit.Test;

public class Backtracking_KnapSackProblem {

  int sackMaxWeight;
  int bigestValue;
  int itemCounts;
  int[] weights;
  int[] values;
  int[] x;
  int[] bestX;
  boolean debug=true;
  int pathsCount;

  public Backtracking_KnapSackProblem(){
    sackMaxWeight = 14;
    itemCounts=4;
    x=new int[itemCounts];
    bestX=new int[itemCounts];
    weights= new int[] {7,6,5,3};
    values=new int[]{6,5,4,5};
  }

  //cw当前包内物品重量，cv当前包内物品价值
  public void dfs(int i,int cv, int cw) {

    if(i==itemCounts){

      pathsCount++;
      print("result: ",i,cv,cw);
      if(cv>bigestValue){
        bigestValue=cv;
        for (int j = 0; j < itemCounts; j++) {
          bestX[j]=x[j];
        }
      }
    }else{
      for (int j = 0; j < 2; j++) {
            x[i]=j;
            if(cw+j*weights[i] <= sackMaxWeight){
//              print("dfs",i,cv,cw);
              dfs (i+1,cv+j*values[i],cw+j*weights[i]);
            }else{
              if(debug){
//                print("stop dfs",i,cv,cw);
              }
            }
      }      
    }



  }

  private void print (String title,int i, int cv, int cw) {
    System.out.println (title+ " : iTh: " + i + " cv: "+ cv + " cw: "+cw);
    System.out.println ("x items");
    for (int j = 0; j <i ; j++) {
      if(x[j]==1) {
        System.out.print (" "+weights[j]+" ");
      }else{
        System.out.print (" null ");
      }
    }
    System.out.println("\r\n");
    System.out.println ("------------------------");
  }

  @Test
  public void test() {
    dfs(0,0,0);
   printBest();
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

}
