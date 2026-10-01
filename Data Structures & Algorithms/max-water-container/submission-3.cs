public class Solution {
    public int MaxArea(int[] heights) {
        int x = 0, y = heights.Count()-1;
        int max = 0;
        while(x<y){
            if(((y-x) * Math.Min(heights[x], heights[y])) > max){
                max = ((y-x) * Math.Min(heights[x], heights[y]));
            }

            if(heights[x] < heights[y]){
                x++;
            }else{
                y--;
            }
        }
        return max;
    }
}
