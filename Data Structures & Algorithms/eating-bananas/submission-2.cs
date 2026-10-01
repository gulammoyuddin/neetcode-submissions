public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        int max = 0;
        foreach(int i in piles){
            max = Math.Max(max, i);
        }
        int a = 1, b= max, n=piles.Count();
        int mid = 0, k = int.MaxValue;
        while(a<=b){
            mid = a+(b-a)/2;
            int t = findTime(piles, mid);
            // Console.WriteLine(a + " - "+ b);
            // Console.WriteLine(mid + " - " + t);
            if(t > h){
                a=mid+1;
            }else if(t <= h){
                k=Math.Min(k,mid);
                b=mid-1;
            }
        }
        if(a==b && findTime(piles,mid)>h && findTime(piles, a)<=h){
            return Math.Min(k,a);
        }
        return k;
    }
    public static int findTime(int[] piles, int k){
        int time = 0;
        foreach(int i in piles){
            decimal r = (decimal)i/k;
            time=time + (int)Math.Ceiling(r);
        }
        return time;
    }
}
