class Solution {
    public ArrayList<Integer> ar;
    public Solution(){
        ar = new ArrayList();
        ar.add(0);
        ar.add(1);
        ar.add(2);
    }
    public int climbStairs(int n) {
    if(ar.size() <= n) {
        ar.add(climbStairs(n-1) + climbStairs(n-2));
    }
     return ar.get(n);
    }
}
