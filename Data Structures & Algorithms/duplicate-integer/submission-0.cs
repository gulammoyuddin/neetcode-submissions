public class Solution {
    public bool hasDuplicate(int[] nums) {
        HashSet<int> hs = new HashSet<int>(nums);
        return hs.Count() != nums.Count();
    }
}