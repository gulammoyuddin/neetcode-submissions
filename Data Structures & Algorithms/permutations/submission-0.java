class Solution {
    public List<List<Integer>> hs;
    public List<List<Integer>> permute(int[] nums) {
        hs = new ArrayList<List<Integer>>();
        makePermutations(nums, new ArrayList<Integer>());
        return hs;
    }
    public void makePermutations(int[] nums, List<Integer> perm){
        if(perm.size() == nums.length){
            hs.add(new ArrayList<Integer>(perm));
            return;
        }
        for(int i = 0; i< nums.length; i++){
            if(!perm.contains(nums[i])){
                perm.add(nums[i]);
                makePermutations(nums, perm);
                perm.remove(perm.size() - 1);
            }
        }
    }
}
