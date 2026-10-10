class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] cost1 = new int[nums.length];
        int[] cost2 = new int[nums.length];
        Arrays.fill(cost1, -1);
        Arrays.fill(cost2, -1);
        cost1[0] = nums[0];
        cost2[1] = nums[1];
        findCost(nums, nums.length-1, 1, cost2);
        findCost(nums, nums.length-2, 0, cost1);
        // System.out.println(cost[nums.length-2]);
        return Math.max(cost2[nums.length-1], cost1[nums.length-2]);   
    }
    public int findCost(int[] nums, int i, int start, int[] cost){
        if(i<start) return 0;
        if(cost[i] != -1) return cost[i];
        return cost[i] = Math.max(findCost(nums, i-2, start, cost)+nums[i], findCost(nums, i-1, start, cost));
    }
}
