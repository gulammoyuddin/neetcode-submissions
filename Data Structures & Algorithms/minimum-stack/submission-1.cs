public class MinStack {
    private LinkedList<int> vals;
    private LinkedList<int> min;
    public MinStack() {
        this.vals = new LinkedList<int>();
        this.min = new LinkedList<int>();
    }
    
    public void Push(int val) {
        this.vals.AddLast(val);
        if(this.min.Count() == 0){
            this.min.AddLast(val);
        }else{
            if(this.min.Last() >= val) this.min.AddLast(val);
        }
    }
    
    public void Pop() {
        int i = this.vals.Last();
        this.vals.RemoveLast();
        if(this.min.Last() == i) this.min.RemoveLast(); 
    }
    
    public int Top() {
        return this.vals.Last();
    }
    
    public int GetMin() {
        return this.min.Last();
    }
}
