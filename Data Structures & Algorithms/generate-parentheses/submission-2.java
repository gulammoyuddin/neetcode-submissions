class Solution {
    public HashSet<String> hs;
    public HashSet<String> ps;
    public List<String> generateParenthesis(int n) {
        hs = new HashSet<String>();
        makeParenthesis(n,0,0, "");
        return new ArrayList(hs);
    }
    public void makeParenthesis(int n,int open, int close, String p) {
        if((close > open) || (open > n)){
            return;
        }
        if(p.length() == (2*n)){
            hs.add(p);
            return;
        }
        makeParenthesis(n, open+1, close,p+"(");
        makeParenthesis(n, open, close+1, p+")");
    }
}
