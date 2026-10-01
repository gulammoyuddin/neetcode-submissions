public class Solution {
    public int MaxProfit(int[] prices) {
        int a = 0, b = 0, l = prices.Count(), max = 0;
        
        while(b<l){
            int curr = prices[b]-prices[a];
            max = Math.Max(curr, max);
            if(curr >= 0){
                b++;
            }else{
                a++;
            }
        }
        return max;
    }
}
