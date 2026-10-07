class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<Integer>();
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        if(num < maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }

        while(Math.abs(maxHeap.size() - minHeap.size()) > 1){
            if(maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.poll());
            }else{
                maxHeap.add(minHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        double res = 0;

        if(maxHeap.size() > minHeap.size()){
            return (double) maxHeap.peek();
        }else if(maxHeap.size() < minHeap.size()){
            return (double) minHeap.peek();
        }else{
            res = ((double) minHeap.peek() + (double) maxHeap.peek()) / 2;
        }
        return res;
    }
}
