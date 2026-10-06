class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            int distA = (a[0]*a[0]) + (a[1]*a[1]);
            int distB = (b[0]*b[0]) + (b[1]*b[1]);
            return Integer.compare(distB, distA);
        });

        for(int[] i: points){
            if(pq.size() < k){
                pq.add(i);
                continue;
            }

            int[] p = pq.peek();
            int distP = (p[0]*p[0]) + (p[1]*p[1]);
            int distI = (i[0]*i[0]) + (i[1]*i[1]);

            if(distP > distI){
                if(pq.size() == k) pq.poll();
                pq.add(i);
            }
        }
        int[][] res = new int[k][2];
        int i = 0;
        for(int[] p: pq){
            res[i] = new int[2];
            res[i][0] = p[0];
            res[i][1] = p[1];
            i++;
        }
        return res;
    }
}
