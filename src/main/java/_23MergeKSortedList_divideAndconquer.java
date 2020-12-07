import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _23MergeKSortedList_divideAndconquer {

  public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length==0) return null;
        return merge(lists,0,lists.length-1);


  }

  private ListNode merge (ListNode[] lists, int left, int right) {
        if(left==right){
          return lists[left];
        }

        int mid=left + (right-left)/2;
        ListNode l1 = merge(lists,left,mid);
        ListNode l2 = merge(lists,mid+1,right);
        return  mergeTwoeLists(l1,l2);
  }

  private ListNode mergeTwoeLists (ListNode l1, ListNode l2) {
    if(l1==null) return l2;
    if(l2==null) return l1;
    if(l1.val<l2.val){
      l1.next=mergeTwoeLists (l1.next,l2);
      return l1;
    }else{
      l2.next=mergeTwoeLists (l1,l2.next);
      return l2;
    }

  }

  @Test
  public void test() {
    ListNode[] lists = new ListNode[3];
    lists[0]=ListNode.createList (new int[]{1,3,7});
    lists[1]=ListNode.createList (new int[]{3,5,8});
    lists[2]=ListNode.createList (new int[]{1,2,4});
    ListNode listNode = mergeKLists (lists);
    System.out.println (listNode.toString ());

  }



}
