public class Solution {
    public bool IsPalindrome(string s) {
        s = s.ToLower();
        int l = s.Count();
        int x = 0, y = l - 1;
        while(x <l && y>=0){
            if(char.IsLetterOrDigit(s[x]) && char.IsLetterOrDigit(s[y])){
                if(s[x] == s[y]){
                    x++;
                    y--;
                }else{
                    return false;
                }
            }else{
            if(!char.IsLetterOrDigit(s[x])){
                x++;
            }
            if(!char.IsLetterOrDigit(s[y])){
                y--;
            }}
        }
        return true;
    }
}
