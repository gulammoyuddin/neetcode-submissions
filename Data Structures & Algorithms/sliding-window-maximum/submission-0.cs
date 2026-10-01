public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) {
        int l =nums.Count();
        int[] res = new int[l - k + 1];
        var maxHeap = new PriorityQueue<int, int>(Comparer<int>.Create((x, y) => y.CompareTo(x)));

        int a=0, b=0, i = 0;
        for(int j = 0; j<k; j++){
            maxHeap.Enqueue(nums[b], nums[b]);
            b++;
        }
        // foreach(var item in maxHeap.UnorderedItems){
        //     Console.WriteLine(item);
        // }
        while(b<l){
            maxHeap.TryPeek(out int num, out int pri);
            // Console.WriteLine(num);
            res[i] = num;
            maxHeap.Remove(nums[a], out int task, out int p);
            maxHeap.Enqueue(nums[b], nums[b]);
            a++;
            b++;
            i++;
        }
        maxHeap.TryPeek(out int n, out int pi);
        // Console.WriteLine(n);
        res[i] = n;
        return res;
    }
}
