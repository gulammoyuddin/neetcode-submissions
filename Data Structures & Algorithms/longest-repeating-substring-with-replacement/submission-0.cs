public class Solution {
    public int CharacterReplacement(string s, int k) {
        int a = 0, b = 0, dCount = 0, l = s.Count(), max = 0;
        Dictionary<char, int> ht = new Dictionary<char, int>();
        while(b<l){
            char c = s[b];
            if(ht.ContainsKey(c)){
                ht[c] = ht[c] + 1;

            }else{
                ht[c] = 1;
            }
            dCount = getReplacementCount(ht);
            while(dCount > k){
                char d  = s[a];
                if(ht[d] > 0){
                    ht[d] = ht[d]-1;
                }else{
                    ht.Remove(d);
                }
                dCount = getReplacementCount(ht);
                a++;
            }
            b++;
            max = Math.Max(max, b-a);
        }
        return max;
    }

    public static char maxFreqChar(Dictionary<char, int> ht){
        char res = 'A';
        int max = 0;
        foreach(var kvp in ht){
            if (kvp.Value > max){
                res = kvp.Key;
                max = kvp.Value;
            }
        }
        return res;
    }

    public static int getReplacementCount(Dictionary<char, int> ht){
        char maxChar = maxFreqChar(ht);

        int res = 0;
        foreach(var kvp in ht){
            if(maxChar == kvp.Key){
                continue;
            }
            res+=kvp.Value;
        }
        return res;
    }
}
