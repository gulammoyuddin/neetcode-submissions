class KthLargest {
    int n;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        n = k;
        pq = new PriorityQueue<Integer>();

        for(int i: nums){
            pq.add(i);
        }
        while(pq.size() > n){
            pq.poll();
        }
    }
    
    public int add(int val) {
        if(pq.isEmpty()){
            pq.add(val);
            return val;
        }
        if(pq.peek() < val){
            if(pq.size() == n) pq.poll();
            pq.add(val);
        }
        return pq.peek();
    }
}
