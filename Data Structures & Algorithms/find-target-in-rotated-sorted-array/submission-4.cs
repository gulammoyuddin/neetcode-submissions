public class Solution {
    public int Search(int[] nums, int target) {
        int min = findMin(nums), n=nums.Count();
        int a,b;
        Console.WriteLine(min);
        if(target >= nums[min] && target<=nums[n-1]){
            a=min;
            b=n;
        }else if(min>0 && target >= nums[0] && target<=nums[min-1]){
            a=0;
            b=min-1;
        }else{
            return -1;
        }
        Console.WriteLine(a+" - "+b);

        while(a<=b && a<n){
            int mid = a + (b-a)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]>target){
                b=mid-1;
            }else{
                a=mid+1;
            }
        }
        
        return -1;
    }

    public static int findMin(int[] nums){
        int a = 0, b = nums.Count(), min =0;

        while(a<b){
            int mid = a + (b-a)/2;
            if(nums[mid]>nums[Math.Min(b,nums.Count()-1)]){
                a=mid+1;
            }else{
                if(nums[mid]<nums[min]){
                    min=mid;
                }
                b=mid-1;
            }
        }
        if(nums[a]<nums[min]){
            min=a;
        }
        return min;
    }
}
