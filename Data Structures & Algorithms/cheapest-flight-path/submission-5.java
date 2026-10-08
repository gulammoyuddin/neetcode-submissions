class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<List<int[]>>();
    
        for(int i =0; i<n; i++) adj.add(new ArrayList<int[]>());

        for(int[] f : flights){
            adj.get(f[0]).add(new int[] { f[1], f[2]});
        }

        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);

        prices[src] = 0;

        for(int i=0; i<k+1; i++){
            int[] temp = Arrays.copyOf(prices, n);
            for(int j = 0; j<flights.length; j++){
                int[] edge = flights[j];
                int u = edge[0], v = edge[1], w = edge[2];
                if(prices[u] == Integer.MAX_VALUE) continue;

                if(prices[u] + w < temp[v]){
                    temp[v] = prices[u] + w;
                }
            }
            prices = Arrays.copyOf(temp, n);
            for(int a: prices){
                System.out.print(a + ", ");
            }
            System.out.println("");
        }

        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }

}
