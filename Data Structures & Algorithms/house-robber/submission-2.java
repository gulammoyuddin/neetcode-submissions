class Solution {
    int[] cost;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        cost = new int[nums.length];
        Arrays.fill(cost, -1);
        cost[0] = nums[0];
        cost[1] = Math.max(nums[0],nums[1]);
        findCost(nums, nums.length-1);
        return Math.max(cost[nums.length-1], cost[nums.length-2]);
    }
    public int findCost(int[] nums, int i){
        if(cost[i] != -1) return cost[i];
        return cost[i] = Math.max(findCost(nums, i-2)+nums[i], findCost(nums, i-1));
    }
}
