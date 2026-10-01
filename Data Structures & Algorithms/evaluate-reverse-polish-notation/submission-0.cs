public class Solution {
    public int EvalRPN(string[] tokens) {
        Stack<int> st = new Stack<int>();
        int x, y = 0;
        foreach(string s in tokens){
            switch(s){
                case "/":
                    x = st.Pop();
                    y = st.Pop();
                    st.Push(y/x);
                    break;
                case "*":
                    x = st.Pop();
                    y = st.Pop();
                    st.Push(y*x);
                    break;
                case "-":
                    x = st.Pop();
                    y = st.Pop();
                    st.Push(y-x);
                    break;
                case "+":
                    x = st.Pop();
                    y = st.Pop();
                    st.Push(y+x);
                    break;
                default:
                    st.Push(int.Parse(s));
                    break;
            }
        }
        return st.Pop();
    }
}
