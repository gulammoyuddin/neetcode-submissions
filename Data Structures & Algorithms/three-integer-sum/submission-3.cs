public class Solution {
    public List<List<int>> ThreeSum(int[] nums) {
        List<List<int>> res = new List<List<int>>();
        Array.Sort(nums);
        int l = nums.Count();
        for(int i = 0; i<l ; i++){
            int x = i+1, y = l-1;
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(x<l && y>=0 && x<y){
                int n = nums[x] + nums[y] + nums[i];
                if(n == 0){
                    res.Add(new List<int>{nums[i],nums[x],nums[y]});
                    x++;
                    y--;
                    while(x<y && nums[x] == nums[x-1]) x++;
                    while(x<y && nums[y] == nums[y+1]) y--;
                }else if (n < 0){
                    x++;
                }else{
                    y--;
                }
            }
        }
        return res;
    }
}
