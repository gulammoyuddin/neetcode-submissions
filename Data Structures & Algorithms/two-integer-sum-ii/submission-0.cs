public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        int l = numbers.Count();
        int x = 0, y = l-1;
        int[] res = new int[2];
        while(x<l && y >= 0 && x<y){
            int sum = numbers[x] + numbers[y];
            if(sum == target){
                res[0] = x+1;
                res[1] = y+1;
                return res;
            }else if(sum < target){
                x++;
            }else{
                y--;
            }
        }
        return res;
    }
}
