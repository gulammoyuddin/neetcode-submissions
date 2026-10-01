public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> d1 = new Dictionary<int, int>();
        int[] res = new int[2];
        for(int i = 0; i < nums.Count(); i++){
            if(d1.ContainsKey(target - nums[i])){
                res[0] = d1[target - nums[i]];
                res[1] = i;
                return res;
            }else{
                d1[nums[i]] = i;
            }
        }
        return res;
    }
}
