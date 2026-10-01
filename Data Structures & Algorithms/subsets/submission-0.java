class Solution {
    private List<List<Integer>> hs;
    public List<List<Integer>> subsets(int[] nums) {
        hs = new ArrayList<List<Integer>>();
        makeSubsets(nums, 0, new ArrayList<Integer>());
        return hs;
    }   
    public void makeSubsets(int[] nums, int currIndex, ArrayList<Integer> sub){
        // System.out.println(sub.size());
        hs.add(new ArrayList(sub));
        for(int i = currIndex; i < nums.length; i++){
            sub.add(nums[i]);
            makeSubsets(nums, i+1, sub);
            sub.remove(sub.size() - 1);
        }
    }
}
