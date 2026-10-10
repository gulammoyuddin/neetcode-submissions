class Solution {
    int[] num;
    public int minCostClimbingStairs(int[] cost) {
        num = new int[cost.length];
        Arrays.fill(num, Integer.MAX_VALUE);
        num[0] = cost[0];
        num[1] = cost[1];
        findCost(cost, cost.length - 1);
        return Math.min(num[cost.length - 1], num[cost.length - 2]);
    }   
    public int findCost(int[] cost, int i){
        if(num[i] < Integer.MAX_VALUE){
            return num[i];
        }
        return num[i] = Math.min(findCost(cost, i-1), findCost(cost, i-2)) + cost[i];
    }
}
