public class Solution {

    public string Encode(IList<string> strs) {
       string res = "";
       foreach(string s in strs){
        string g = s.Replace("\\","\\\\").Replace(".", "\\.").Replace("-", "\\-");
        if(g == ""){
            g = ".";
        }
        res = res == "" ? g : res + "-" + g;
       }
       Console.Write(res);
       return res;
    }

    public List<string> Decode(string s) {
        int l = s.Count();
        int x = 0;

        List<string> res = new List<string>();
        StringBuilder sb = new StringBuilder();

        while(x<l){
            if(s[x] == '\\'){
                x++;
                sb.Append(s[x]);
                x++;
            }else if(s[x] == '-'){
                if(sb.ToString() != "") res.Add(sb.ToString());
                sb.Clear();
                x++;
            }
            else if (s[x] == '.'){
                res.Add("");
                x++;
            }
            else{
                sb.Append(s[x]);
                x++;
            }
        }
        if(sb.ToString() != "") res.Add(sb.ToString());
        return res;
   }
}
