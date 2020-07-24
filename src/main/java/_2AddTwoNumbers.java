import org.junit.Assert;
import org.junit.Test;

/**
 *
 * <pre>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * </pre>
 */
public class _2AddTwoNumbers {


  @Test
  public void testAddTowNumber(){

    int[] sum1={2,3,4,1};
    int[] sum2={4,6,5};

    ListNode start1=transformToReverseListNode(sum1);
    ListNode start2=transformToReverseListNode(sum2);


    ListNode listNode = addTwoNumbers (start1, start2);
    Assert.assertEquals ("2806",listNode.toString ());


     listNode = addTwoNumbers2 (start1, start2);
    Assert.assertEquals ("2806",listNode.toString ());

    int[] sum12={9,9,9};
    int[] sum22={1};
     start1=transformToReverseListNode(sum12);
     start2=transformToReverseListNode(sum22);

    listNode = addTwoNumbers2 (start1, start2);
    Assert.assertEquals ("1000",listNode.toString ());

  }


  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

    int carry=0;
    ListNode start=new ListNode (0);
    ListNode cur=start;
    while(l1!=null||l2!=null){
      int l1Cur=l1==null?0:l1.val;
      int l2Cur=l2==null?0:l2.val;

        int sum=carry+l1Cur+l2Cur;
        cur.val=sum%10;
        carry=sum/10;

      l1=l1==null?null:l1.next;
      l2=l2==null?null:l2.next;
        if(carry!=0||l1!=null||l2!=null){
          cur.next=new ListNode (carry);
          cur=cur.next;
        }


    }

    return start;
  }


  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

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

  /**
   * number 203 will be saved as 3->0-<2
   * and return the first node
   */
  private ListNode transformToReverseListNode (int[] sum1) {
    if(sum1.length==0) return null;

    ListNode start=new ListNode (0);
    ListNode cur=start;
    for (int i=sum1.length-1;i>=0;i--){
      cur.val=sum1[i];
      if(i!=0){
        cur.next=new ListNode (sum1[i-1]);
      }
      cur=cur.next;
    }
    return start;

  }

  private static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public String toString(){

      if(next==null){
        return val+"";
      }else{
        return next.toString ()+val;
      }

    }

  }


}