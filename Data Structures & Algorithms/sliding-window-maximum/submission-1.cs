public class Solution {
    public int[] MaxSlidingWindow(int[] nums, int k) {
        LinkedList<int> deq = new LinkedList<int>();
        int a = 0, b= 0, l = nums.Count(), i= 0;
        int[] res = new int[l-k+1];
        while(b<k){
            if(!deq.Any()){
                deq.AddLast(nums[b]);
            }else{
                while(deq.Any() && deq.Last.Value < nums[b]){
                    deq.RemoveLast();
                }
                deq.AddLast(nums[b]);
            }
            b++;
        }
        while(b<l){
            res[i] = deq.First.Value;
            if(nums[a] == deq.First.Value){
                deq.RemoveFirst();
            }
            while(deq.Any() && deq.Last.Value < nums[b]){
                deq.RemoveLast();
            }
            deq.AddLast(nums[b]);
            a++;
            i++;
            b++;
        }
        res[i] = deq.First.Value;
        return res;
    }
}
