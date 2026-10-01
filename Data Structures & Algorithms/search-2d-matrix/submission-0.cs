public class Solution {
    public bool SearchMatrix(int[][] matrix, int target) {
      int a = 0, b = matrix.Count(), mid = 0, x = matrix.Count(), y = matrix[0].Count();
      while(a<b){
        mid = a + (b-a)/2;
        //Console.WriteLine(mid);
        if(matrix[mid][0] <= target && target <= matrix[mid][y-1]){
            
            return search(matrix[mid], target) != -1;
        }else if(matrix[mid][0] > target){
            b = mid-1;
        }else{
            a = mid+1;
        }
      }  
      if(a == b && a<x && matrix[a][0] <= target && target <= matrix[a][y-1]){
            return search(matrix[a], target) != -1;
      }
      return false;
    }
    public static int search(int[] n, int t){
        int a = 0, b=n.Count();
        int mid = 0;
        while(a<b){
            mid = a + (b-a)/2;
            if(n[mid] == t){
                return mid;
            }else if(n[mid] > t){
                b=mid-1;
            }else{
                a=mid+1;
            }
        }
        if(a==b && a< n.Count() && n[a]==t){
            return a;
        }
        return -1;
    }
}
