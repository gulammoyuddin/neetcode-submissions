public class Solution {
    public int LargestRectangleArea(int[] heights) {
        int l = heights.Count();
        int[] smallLeft = new int[l],smallRight = new int[l];
        Stack<int> st = new Stack<int>();
        for(int i = 0; i < l; i++){
            if(st.Any()){
                while(st.Any() && heights[st.Peek()] > heights[i]){
                    st.Pop();
                }
                if(st.Any()){
                    smallLeft[i] = st.Peek();
                }else{
                    smallLeft[i] = i;  
                }
            }else{
                smallLeft[i] = i;
            }
            st.Push(i);
        }
        st.Clear();
        for(int i = l-1; i >= 0; i--){
           if(st.Any()){
                while(st.Any() && heights[st.Peek()] >= heights[i]){
                    st.Pop();
                }
                if(st.Any()){
                    smallRight[i] = st.Peek();
                }else{
                    smallRight[i] = i;  
                }
            }else{
                smallRight[i] = i;
            }
            st.Push(i); 
        }
        int max = 0;
        for(int i = 0; i< l; i++){
            // Console.WriteLine("left-index - "+smallLeft[i]);
            // Console.WriteLine("right-index - "+smallRight[i]);
            int left = smallLeft[i] == i ? Math.Max(0,i) : i-smallLeft[i]-1;
            int right = smallRight[i] == i ? l-i-1 : smallRight[i]-i-1;

            // Console.WriteLine("left - " + left);
            // Console.WriteLine("right - "+ right);


            max = Math.Max(max, (heights[i] * (left + right+1)));
        }
        return max;
    }
}
