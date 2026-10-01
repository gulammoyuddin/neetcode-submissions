public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        Dictionary<int, int> count = new Dictionary<int, int>();
        var comparer = Comparer<int>.Create((x,y) => y.CompareTo(x));
        PriorityQueue<int, int> pq = new PriorityQueue<int, int>(comparer);
        foreach(int i in nums){
            if(count.ContainsKey(i)){
                count[i] = count[i]+1;
            }else{
                count[i] = 1;
            }
        }

        foreach(var kvp in count){
            pq.Enqueue(kvp.Key, kvp.Value);
        }

        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = pq.Dequeue();
        }
        return res;
    }
}
