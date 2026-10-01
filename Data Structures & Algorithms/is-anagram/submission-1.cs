public class Solution {
    public bool IsAnagram(string s, string t) {
        Dictionary<char, int> d1 = new Dictionary<char, int>();
        Dictionary<char, int> d2 = new Dictionary<char, int>();

        foreach(char i in s){
            if(d1.ContainsKey(i)){
                d1[i] = d1[i] + 1;
            }else{
                d1[i] = 1;
            }
        }

        foreach(char i in t){
            if(d2.ContainsKey(i)){
                d2[i] = d2[i] + 1;
            }else{
                d2[i] = 1;
            }
        }

        foreach(var kvp in d1){
            if(!d2.ContainsKey(kvp.Key) || d2[kvp.Key] != kvp.Value){
                return false;
            }
        }
        return true && d1.Count == d2.Count;
    }
}
