class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        HashSet<Integer> hs = new HashSet<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            return Integer.compare(grid[a/m][a%m], grid[b/m][b%m]);
        });

        pq.add(0);
        int curr = 0;
        int max = 0;
        
        while(!pq.isEmpty() && curr != ((n*m)-1)){
            curr = pq.poll();
            int i = curr/m, j = curr%m;
            // System.out.println("i:- "+i+" j:- "+j+" w:- "+grid[i][j]);
            
            if(hs.contains(curr)) continue;
            max = Math.max(grid[i][j], max);
            hs.add(curr);

            if(i-1>=0 && !hs.contains(((i-1)*m)+j)){
                pq.add(((i-1)*m)+j);
            }
            if(i+1<n && !hs.contains(((i+1)*m)+j)){
                pq.add(((i+1)*m)+j);
            }
            if(j-1>=0 && !hs.contains((i*m)+j-1)){
                pq.add((i*m)+j-1);
            }
            if(j+1<m && !hs.contains((i*m)+j+1)){
                pq.add((i*m)+j+1);
            }
        }
        return max;
    }
}
