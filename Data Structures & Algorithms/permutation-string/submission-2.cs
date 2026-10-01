public class Solution {
    public bool CheckInclusion(string s1, string s2) {

        if(s1.Count() > s2.Count()) return false;

        Dictionary<char, int> h1 = new Dictionary<char, int>(),
            h2 = new Dictionary<char, int>();
        
        foreach(char c in s1){
            h1[c] = h1.ContainsKey(c) ? h1[c] + 1: 1;
        }

        int a = 0, b = 0;

        while(b < s1.Count()){
            h2[s2[b]] = h2.ContainsKey(s2[b]) ? h2[s2[b]]+1:1;
            b++;
        }

        while(b < s2.Count()){
            if(isPerm(h1, h2)) return true;
            Console.WriteLine("a - "+a+" b - "+b);
            
            h2[s2[b]] = h2.ContainsKey(s2[b]) ? h2[s2[b]]+1:1;
            h2[s2[a]] = Math.Max(h2[s2[a]]-1, 0);
            a++;
            b++;
        }
        return isPerm(h1,h2);
    }
    public static bool isPerm(Dictionary<char, int> h1, Dictionary<char, int> h2){
        
        foreach(var kvp in h1){
            if(!h2.ContainsKey(kvp.Key)) return false;
            if(h2[kvp.Key] != kvp.Value) return false;
        }
        
        return true;
    }
}
