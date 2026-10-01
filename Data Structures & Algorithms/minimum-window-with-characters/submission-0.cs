public class Solution {
    public string MinWindow(string s, string t) {
        Dictionary<char, int> h1 = new Dictionary<char, int>(),
            h2 = new Dictionary<char, int>();
        int a = 0, b = 0, min = int.MaxValue, lt = t.Count();
        string res = "";

        foreach(char c in t){
            h1[c] = h1.ContainsKey(c) ? h1[c]+1 : 1;
        }
        while(b<s.Count()){
            if(b-a<lt){
                h2[s[b]] = h2.ContainsKey(s[b]) ? h2[s[b]]+1:1;
                b++;
            }else{
                bool isP = isPresent(h1, h2);
                // Console.WriteLine(isP + " a "+a+" b "+b);
                if(isP){
                    if(b-a < min){
                        min = b-a;
                        res = s.Substring(a, min);
                    }
                    h2[s[a]] = Math.Max(h2[s[a]]-1, 0);
                    a++;
                }else{
                    h2[s[b]] = h2.ContainsKey(s[b]) ? h2[s[b]]+1:1;
                    b++;
                }
            }
        }
        // Console.WriteLine(isPresent(h1,h2) + " a "+a+" b "+b);
        while(b-a>=lt && isPresent(h1,h2)){
            // Console.WriteLine(" a- "+a+" b- "+b);
            if(b-a < min){
                min = b-a;
                res = s.Substring(a, min);
            }
            h2[s[a]] = Math.Max(h2[s[a]]-1, 0);
            a++;
        }
        // if(isPresent(h1, h2) && (b-a < min))
        // {
        //     min = b-a;
        //     res = s.Substring(a, b);
        // }
        return res;
    }

    public static bool isPresent(Dictionary<char, int> h1, Dictionary<char, int> h2){
        foreach(var kvp in h1){
            if(!h2.ContainsKey(kvp.Key)) return false;
            if(h2[kvp.Key] < kvp.Value) return false; 
        }
        return true;
    }
}
