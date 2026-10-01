public class Solution {
    public int LongestConsecutive(int[] nums) {
        Dictionary<int, int> parent = new Dictionary<int, int>();
        Dictionary<int, List<int>> child = new Dictionary<int, List<int>>();
        int max = 0;
        foreach (int i in nums){
            if(parent.ContainsKey(i)){
                continue;
            }
            if (parent.ContainsKey(i-1) && parent.ContainsKey(i+1)){
                int parentId = parent[i-1];
                parent[i] = parentId;
                child[parentId].Add(i);
                int mergeParentId = parent[i+1];
                parent[mergeParentId] = parentId;
                foreach(int k in child[mergeParentId]){
                    parent[k] = parentId;
                }
                child[parentId].AddRange(child[mergeParentId]);
                max = Math.Max(max, child[parentId].Count());
            }else if(parent.ContainsKey(i-1)){
                int parentId = parent[i-1];
                parent[i] = parentId;
                child[parentId].Add(i);
                max = Math.Max(max, child[parentId].Count());
            }else if(parent.ContainsKey(i+1)){
                int parentId = parent[i+1];
                parent[i] = parentId;
                child[parentId].Add(i);
                max = Math.Max(max, child[parentId].Count());
            }else{
                parent[i] = i;
                child[i] = new List<int>{ i };
                max = Math.Max(max, 1);
            }
        }
        return max;
    }
}
