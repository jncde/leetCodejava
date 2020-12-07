public class _23MergeKList {


  public ListNode doMerge(ListNode[] lists) {
    if(lists==null||lists.length==0){
      return null;
    }

    return divideKList(lists,0,lists.length-1);

  }

  private ListNode divideKList (ListNode[] lists, int left, int right) {

    if(left==right){
      return lists[left];
    }

    int mid=left+(right-left)/2;
    ListNode listNode = divideKList (lists, left, mid);
    ListNode rightNode = divideKList (lists, mid+1, right);

    return mergeTowList(listNode,rightNode);

  }

  private ListNode mergeTowList (ListNode listNode, ListNode rightNode) {

    return null;
  }

}
