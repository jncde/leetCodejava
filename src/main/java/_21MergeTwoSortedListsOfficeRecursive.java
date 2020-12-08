import org.junit.Assert;
import org.junit.Test;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/yi-kan-jiu-hui-yi-xie-jiu-fei-xiang-jie-di-gui-by-/
 *
 * recursive: think!!! What should be the return value!!!
 */
public class _21MergeTwoSortedListsOfficeRecursive {

  public ListNode mergeTwoLists (ListNode l1, ListNode l2) {

    if(l1==null) return l2;
    if(l2==null) return l1;

    if(l1.val<l2.val){
      l1.next=mergeTwoLists (l1.next,l2);
      return l1;
    }else{
      l2.next=mergeTwoLists (l1,l2.next);
      return l2;
    }

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




