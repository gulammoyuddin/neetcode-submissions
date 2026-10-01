public class Solution {
    public int Search(int[] nums, int target) {
        int a = 0, b = nums.Count();
        int mid = 0, res = -1;
        while(a<b){
            mid = a+(b-a)/2;
            Console.WriteLine(mid);
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                a=mid+1;
            }else{
                b=mid-1;
            }
        }
        if(a==b && a<nums.Count() && nums[a]==target){
            return a;
        }
        return res;
    }
}
