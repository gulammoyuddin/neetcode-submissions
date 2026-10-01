class Solution {
    private List<List<Integer>> hs;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        hs = new ArrayList<List<Integer>>();
        makeCombinations(nums, 0, target, new ArrayList<Integer>());
        return hs;
    }
    public void makeCombinations(int[] nums, int currIndex, int target, List<Integer> comb){
        if(target == 0){
            hs.add(new ArrayList(comb));
            return;
        }
        for(int i=currIndex; i < nums.length; i++){
            comb.add(nums[i]);
            if(target - nums[i] >= 0){
                makeCombinations(nums, i, target - nums[i], comb);
            }
            comb.remove(comb.size() - 1);
        }
    }
}
