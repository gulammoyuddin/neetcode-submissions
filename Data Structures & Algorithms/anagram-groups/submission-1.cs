public class Solution {
    public List<List<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, List<string>> d1 = new Dictionary<string, List<String>>();

        foreach(string s in strs){
            var sort = sortString(s);
            if(d1.ContainsKey(sort)){
                d1[sort].Add(s);
            }else{
                d1[sort] = new List<string>{ s };
            }
        }

        return d1.Values.ToList();
    }

    public static string sortString(string s){
        int[] charCount = new int[26];
        foreach(char c in s){
            charCount[c - 'a']++; 
        }
        string result = "";
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < charCount[i]; j++){
                result += (char)('a' + i);
            }
        }
        return result;
    }
}
