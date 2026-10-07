class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Hashtable<Integer,List<int[]>> ht =  new Hashtable<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a[1], b[1]);
        });

        HashSet<Integer> hs = new HashSet<>();

        int[] weights = new int[n+1];


        int res = 0;

        for(int i = 1; i <= n; i++){
            ht.put(i, new ArrayList<int[]>());
            weights[i] = Integer.MAX_VALUE; 
        }

        for(int[] i: times){
            if(!ht.containsKey(i[0])){
                ht.put(i[0], new ArrayList<int[]>());
            }
            ht.get(i[0]).add(i);
        }
        weights[k] = 0;
        minHeap.add(new int[] { k, 0});

        while(!minHeap.isEmpty()){
            int[] top = minHeap.poll();
            int u = top[0];
            int dist = top[1];

            // System.out.println(u +", "+ dist);

            if(dist > weights[u]) continue;

            for(int[] edge: ht.get(u)){
                int v = edge[1];
                int w = edge[2];

                if(weights[u] + w < weights[v]){
                    weights[v] = weights[u] + w;
                    minHeap.add(new int[] { v, weights[v]});
                }
            }
        }

        for (int i: weights) res = Math.max(res, i);

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
