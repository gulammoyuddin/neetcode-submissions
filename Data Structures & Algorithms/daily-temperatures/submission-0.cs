public class Solution {
    public int[] DailyTemperatures(int[] temperatures) {
        int l = temperatures.Count();
        int[] res = new int[l];
        Stack<int> st = new Stack<int>();
        for (int i = 0; i<l; i++){
            if(!st.Any()){
                st.Push(i);
            }else if(temperatures[st.Peek()] >= temperatures[i]){
                st.Push(i);
            }else{
                int x = 0;
                while(st.Any() && temperatures[st.Peek()] < temperatures[i]){
                    x = st.Pop();
                    res[x] = i-x;
                }
                st.Push(i);
            }
        }
        return res;
    }
}
