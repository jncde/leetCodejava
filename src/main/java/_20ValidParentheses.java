import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class _20ValidParentheses {


  //fist implementation
  public boolean isValid(String s) {

    if(s==null||s.isEmpty ()){
      return true;
    }

    if(s.length()==1){
      return false;
    }

    List<Character> stack=new ArrayList<> ();
    Map<Character,Character> map=new HashMap<> ();
    map.put('(',')');
    map.put('[',']');
    map.put('{','}');

    for(int i=0;i<s.length();i++){
      char c=s.charAt(i);
      if(c=='('||c=='['||c=='{'){
        stack.add(c);
      }else{
        if(stack.size()==0){
          return false;
        }
        char lastC=stack.get(stack.size()-1);
        if(map.get (lastC)!=c){
          return false;
        }else{

          stack.remove(stack.size()-1);
        }

      }

    }

    return stack.size()==0;

  }


  @Test
  public void test() {
    boolean valid = isValid ("()");
    assert valid==true;
    System.out.println (valid);
  }
}
