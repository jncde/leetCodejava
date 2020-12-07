import org.junit.Test;

public class _19RemoveNth{

  /**
   * key: double pointer, dummy node and null node
   *
   */
  public ListNode removeNthNode(ListNode head,int n){
    ListNode dummy=new ListNode(0);
    dummy.next=head;

    ListNode begin=dummy,end=dummy;

    int i=0;
    while(i<n+1){
      i++;
      end=end.next;
    }

    while (end!=null){
      begin=begin.next;
      end=end.next;
    }

    begin.next=begin.next.next;


    // here not head, but dummy.next, otherwise ([1],1) wirll return [1], expected is but []
    return dummy.next;



  }


  @Test
  public void testRun() {

    ListNode h=new ListNode (1);
    ListNode head=h;
    for (int i = 1; i < 5; i++) {
      h.next = new ListNode (i + 1);
      h=h.next;
    }

    System.out.println ("before remove:"+head.toString ());
    ListNode listNode = removeNthNode (head, 2);
    System.out.println ("after remove:"+listNode.toString ());

  }


}