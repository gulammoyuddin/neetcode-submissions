class Solution {
    List<List<Integer>> hs;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        hs = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        makeCombinations(candidates, 0, target, new ArrayList<Integer>());
        return hs;
    }
    public void makeCombinations(int[] nums, int currIndex, int target, List<Integer> comb){
        if(target == 0){
            hs.add(new ArrayList(comb));
            return;
        }
        for(int i=currIndex; i < nums.length; i++){
            int j = i;
            while((i+1)< nums.length && nums[i] == nums[i+1]){
                i++;
            }
            for(int k = 1; k <= (i-j+1); k++){
                int s = 0;
                for(int a = 0; a < k; a++){
                    comb.add(nums[i]);
                    s+=nums[i];
                }
                if(target - s >= 0){
                    makeCombinations(nums, i+1, target - s, comb);
                }
                for(int a = 0; a < k; a++){
                    comb.remove(comb.size() - 1);
                }
            }
        }
    }
}
