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
            int mf = maxFreq(ht);
            dCount = b-a-mf+1;
            // Console.WriteLine(dCount);
            while(dCount > k){
                char d  = s[a];
                if(ht[d] > 0){
                    ht[d] = ht[d]-1;
                }else{
                    ht.Remove(d);
                }
                a++;
                dCount = b-a-mf+1;
                // Console.WriteLine("max freq" + maxFreq(ht));
                // Console.WriteLine("dCount" + dCount);
                
            }
            b++;
            max = Math.Max(max, b-a);
        }
        return max;
    }

    public static int maxFreq(Dictionary<char, int> ht){
        int max = 0;
        foreach(var kvp in ht){
            if (kvp.Value > max){
                max = kvp.Value;
            }
        }
        return max;
    }

}
