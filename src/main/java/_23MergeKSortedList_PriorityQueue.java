import org.junit.Test;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _23MergeKSortedList_PriorityQueue {

  public ListNode mergeKList(List<ListNode> lists) {
    ListNode dummy=new ListNode ();
    ListNode header=dummy;
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<> ();
    for (ListNode l:lists){
      priorityQueue.add (l);
    }

    while (!priorityQueue.isEmpty ()){
      ListNode cur = priorityQueue.poll ();
      header.next=cur;
      header=header.next;
      if(cur.next!=null)
        priorityQueue.add (cur.next);
    }

    return dummy.next;
  }

  @Test
  public void test() {
    ArrayList<ListNode> lists = new ArrayList<> ();
    lists.add (ListNode.createList (new int[]{1,3,7}));
    lists.add (ListNode.createList (new int[]{3,5,8}));
    lists.add (ListNode.createList (new int[]{1,2,4}));
    ListNode listNode = mergeKList (lists);
    System.out.println (listNode.toString ());

  }



}
