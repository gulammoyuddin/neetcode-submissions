public class Solution {
    public int FindMin(int[] nums) {
        int a = 0, b= nums.Count(), min = int.MaxValue;
        while(a<b){
            int mid = a + (b-a)/2;
            // Console.WriteLine(mid);
            int k = b == nums.Count() ? b-1 : b;
            if(nums[k]<nums[mid]){
                a=mid+1;
            }else{
                min = Math.Min(min,nums[mid]);
                b=mid-1;
            }
        }
        return Math.Min(nums[a], min);
    }
}
