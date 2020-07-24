/**
 *<pre>
 *
 *   There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *</pre>
 *
 */
public class _4MedianOfTwoSortedArrays {

  public static void main (String[] args) {
    Solution4 s = new Solution4 ();
    int[] nums1={1,2};
    int[] nums2={3,4};


    System.out.println (s.findMedianSortedArrays (nums1,nums2));
  }

}



class Solution4 {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {

    int m=nums1.length;
    int n=nums2.length;

    int left=(m+n+1)/2;
    int right=(m+n+2)/2;

    return (findK(nums1,0,m-1,nums2,0,n-1,left)+findK(nums1,0,m-1,nums2,0,n-1,right))*0.5;




  }


  private double findK(int[] nums1, int start1,int end1,int[] nums2, int start2,int end2,int k){

    int len1=end1-start1+1;
    int len2=end2-start2+1;

    if(len1>len2)
      return findK(nums2,start2,end2,nums1,start1,end1,k);

    if(len1==0) return nums2[start2+k-1];

    if(k==1) return Math.min(nums1[start1],nums2[start2]);

    int j1=Math.min(len1,k/2)-1;
    int num1K=nums1[start1+j1];
    int j2=Math.min(len2,k/2)-1;
    int num2K=nums2[start2+j2];


    if(num1K<=num2K){
      return findK(nums1,j1+1,end1,nums2,start2,end2,k-(j1+1));
    }else{
      return findK(nums1,start1,end1,nums2,j2+1,end2,k-(j2+1));
    }




  }
}