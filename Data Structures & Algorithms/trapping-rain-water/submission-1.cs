public class Solution {
    public int Trap(int[] height) {
        int l = height.Count();
        int[] maxLeft = new int[l];
        int[] maxRight = new int[l];

        for(int i = 0; i < l; i++){
            if(i == 0){
                maxLeft[i] = height[i];
                maxRight[l-1] = height[l-1];
            }else{
                maxLeft[i] = maxLeft[i-1] > height[i] ? maxLeft[i-1] : height[i];
                maxRight[l-i-1] = maxRight[l-i] > height[l-i-1] ? maxRight[l-i] : height[l-i-1]; 
            }
        }
        int res = 0;
        for(int i = 0; i< l;i++){
            res = res + (Math.Min(maxLeft[i], maxRight[i]) - height[i]);
        }
        return res;
    }
}
