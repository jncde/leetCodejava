/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class _2AddTwoNumbers {

  public static void main (String[] args) {
    ListNode l1 = new ListNode (2);
    ListNode l1Start=l1;
    l1.next=new ListNode (4);
    l1= l1.next;
    l1.next=new ListNode (3);
    l1= l1.next;
    l1.next=new ListNode (2);

    ListNode l2 = new ListNode (5);
    ListNode l2Start=l2;
    l2.next=new ListNode (6);
    l2= l2.next;
    l2.next=new ListNode (4);

    ListNode listNode = addTwoNumbers (l1Start, l2Start);
    System.out.println (listNode.toString ());


  }
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result=new ListNode(0);
    ListNode entryRe=result;


    while(l1!=null||l2!=null){
      if(l1==null){
        ListNode temp=calculSingle(result,l2);
        if(temp==null){
          break;
        }else{
          result=temp;
        }
      }else{
        if(l2==null){
          ListNode temp=calculSingle(result,l1);
          if(temp==null){
            break;
          }else{
            result=temp;
          }
        }else{
          int digital=l1.val+l2.val+result.val;
          result.val=digital%10;
          if(digital>=10){
            result.next=new ListNode(1);
          }else{
            if(l1.next!=null||l2.next!=null){
              result.next=new ListNode(0);
            }
          }
          result=result.next;
        }
      }
      if(l1!=null) l1=l1.next;
      if(l2!=null) l2=l2.next;

    }

    return entryRe;

  }

  private static ListNode calculSingle(ListNode result,ListNode node){
    if(result.val==0){
      result.val=node.val;
      result.next=node.next;
      return null;
    }else{
      int sumL2=(node.val+result.val);
      result.val=sumL2%10;
      if(sumL2>10){
        result.next=new ListNode(1);
        return result.next;
      }else{
        result.next=node.next;
        return null;
      }
    }
  }

}

 class ListNode {
     int val;
     ListNode next;
      ListNode(int x) { val = x; }
      public String toString(){

        if(next==null){
          return val+"";
        }else{
          return val+""+next.toString ();
        }

      }

  }

