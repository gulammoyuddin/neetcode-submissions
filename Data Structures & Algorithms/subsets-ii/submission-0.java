class Solution {
    List<List<Integer>> hs;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        hs = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        makeSubsets(nums,0, new ArrayList<Integer>());
        return hs;
    }
    public void makeSubsets(int[] nums, int currIndex, ArrayList<Integer> sub){
        // System.out.println(sub.size());
        hs.add(new ArrayList(sub));
        for(int i = currIndex; i < nums.length; i++){
            int j = i;
            while(i+1< nums.length && nums[i]==nums[i+1]){
                i++;
            }
            for(int k = 1; k <= (i-j+1); k++){
                for(int a =0; a<k; a++){
                    sub.add(nums[i]);
                }
                makeSubsets(nums, i+1, sub);
                for(int a =0; a<k; a++){
                    sub.remove(sub.size() - 1);      
                }
            }
        }
    }
}
