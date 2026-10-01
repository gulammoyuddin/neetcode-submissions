public class Solution {
    public bool IsValid(string s) {
        Stack<char> st = new Stack<char>();
        foreach(char c in s){
            switch(c){
                case '(': 
                case '[': 
                case '{':
                    st.Push(c);
                    break;
                case ')':
                    if(!st.Any() || st.Peek() != '(') return false;
                    st.Pop();
                    break;
                case ']':
                    if(!st.Any() || st.Peek() != '[') return false;
                    st.Pop();
                    break;
                case '}':
                    if(!st.Any() || st.Peek() != '{') return false;
                    st.Pop();
                    break;
            }
        }
        if(st.Any()) return false;
        return true;
    }
}
