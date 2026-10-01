public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int l = nums.Count();
        int[] res = new int[l];
        int[] res1 = new int[l];
        res[0] = 1;
        for(int i = 1; i < l; i++){
            res[i] = nums[i-1] * res[i-1];
        }
        res1[l-1] = 1;
        for(int i = l - 2; i >= 0; i--){
            res1[i] = res1[i+1] * nums[i+1];
        }
        for(int i = 0; i < l; i++){
            res[i] = res[i]*res1[i];
        }
        return res;
    }
}
