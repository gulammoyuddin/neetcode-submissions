class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i: stones) pq.add(i);

        while(pq.size() >= 2){
            int s1 = pq.poll();
            int s2 = pq.poll();

            // System.out.println(s1+", "+s2);

            if(s1 > s2){
                pq.add(s1 - s2);
            }else if(s1 < s2){
                pq.add(s2 - s1);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}
