class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashSet<int[]> hs = new HashSet<>();
        PriorityQueue<int[][]> pq = new PriorityQueue<>((a,b) -> {
            int distA = Math.abs(a[0][0] - a[1][0]) + Math.abs(a[0][1] - a[1][1]);
            int distB = Math.abs(b[0][0] - b[1][0]) + Math.abs(b[0][1] - b[1][1]);
            return Integer.compare(distA, distB);
        });
        hs.add(points[0]);
        for(int i = 1; i<points.length; i++){
            pq.add(new int[][] { points[0], points[i]});
        }
        int cost = 0;
        while(!pq.isEmpty()){
            int[][] edge = pq.poll();

            if (hs.contains(edge[1])) continue;

            hs.add(edge[1]);
            int d = Math.abs(edge[0][0] - edge[1][0]) + Math.abs(edge[0][1] - edge[1][1]);
            cost += d;

            for(int i = 0; i<points.length; i++){
                if(!hs.contains(points[i])){
                    pq.add(new int[][] { edge[1], points[i]});
                }
            }
        }
        return cost;
    }
}
