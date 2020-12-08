import org.junit.Assert;
import org.junit.Test;

public class _21MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    if(l1==null){
      return l2;
    }

    if(l2==null){
      return l1;
    }

    ListNode dummy=new ListNode(0);
    ListNode lstart=dummy;

    while(l1!=null||l2!=null){

      int l1v=l1==null?Integer.MAX_VALUE:l1.val;
      int l2v=l2==null?Integer.MAX_VALUE:l2.val;

      if(l1v<=l2v){
        lstart.next=l1;
        l1=l1.next;
      }else{
        lstart.next=l2;
        l2=l2.next;
      }

      lstart=lstart.next;


    }

    return dummy.next;



  }

  @Test
  public void test() {

    int[] sequence1 = {1, 2, 4};
    int[] sequence2 = {1, 3, 4};
    ListNode l1 = ListNode.createList (sequence1);
    ListNode l2= ListNode.createList (sequence2);

    ListNode listNode = mergeTwoLists (l1, l2);

    Assert.assertEquals ("[ 1 1 2 3 4 4]",ListNode.listString (listNode));

  }

}




