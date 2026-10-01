public class Solution {
    public int MaxArea(int[] heights) {
        int l = heights.Count();
        int x = 0, y = l-1;
        int max = 0;
        while(x<y){
            int area = (y-x) * Math.Min(heights[x], heights[y]);
            if(area > max){
                max = area;
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
