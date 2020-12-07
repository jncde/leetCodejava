public class ListNode implements Comparable<ListNode>{

  ListNode next;
  int val;
  ListNode(int x) {val=x;}


  public ListNode(){
    this(0);
  }

  public String toString() {
    StringBuilder s=new StringBuilder ();
    s.append ("[");
    toString (s);
    s.append ("]");
    return s.toString ();
  }

  public void toString(StringBuilder s) {
        s.append (' ');
        s.append (val);
        if (next==null){
          return;
        }else{
          next.toString (s);
        }
  }

  public static ListNode createList(int[] sequence){

    ListNode start = null,cur = null;

    for (int i = 0; i < sequence.length; i++) {
      if(i==0){
        start=new ListNode (sequence[i]);
        cur=start;
      }
      else{
        cur.next=new ListNode (sequence[i]);
        cur=cur.next;
      }
    }
    return start;
  }

  @Override
  public int compareTo (ListNode o) {
    return Integer.compare (this.val,o.val);
  }
}