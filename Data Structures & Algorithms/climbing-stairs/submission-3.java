class Solution {
    public Hashtable<Integer,Integer> ar;
    public Solution(){
        ar = new Hashtable();
        ar.put(1, 1);
        ar.put(2, 2);
    }
    public int climbStairs(int n) {
    if(!ar.containsKey(n)) {
        ar.put(n, climbStairs(n-1) + climbStairs(n-2));
    }
     return ar.get(n);
    }
}
