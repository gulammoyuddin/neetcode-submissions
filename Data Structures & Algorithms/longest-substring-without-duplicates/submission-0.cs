public class Solution {
    public int LengthOfLongestSubstring(string s) {
        int l = s.Count(), max = 0;
        string sub = "";
        foreach(char c in s){
            while(sub.Contains(c)){
                sub = sub.Substring(1);
            }
            sub = sub + c;
            max = Math.Max(sub.Count(), max);
        }
        return max;
    }
}
