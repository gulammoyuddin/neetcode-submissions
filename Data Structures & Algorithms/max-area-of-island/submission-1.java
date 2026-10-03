class Solution {
    private int[] parent;
    private int[] rank;
    private int n;
    private int m;
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        parent = new int[n*m];
        rank = new int[n*m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    parent[(i*m)+j] = (i*m)+j;
                    rank[(i*m)+j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(grid[i][j]==1){
                    if((j+1)<m && grid[i][j+1]==1){
                        union((i*m)+j,(i*m)+j+1);
                    }
                    if((i+1)<n && grid[i+1][j]==1){
                        union((i*m)+j,((i+1)*m)+j);
                    }
                }
            }
        }
        int res = 0;
        for(int i=0; i<(n*m); i++){
            // System.out.println("parent:- "+parent[i]+" rank:- "+rank[i]);
            if(parent[i] == i && rank[i]>0){
                res=Math.max(res, rank[i]);
            }
        }
        return res;
    }
    public int find(int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j){
        int root1 = find(i);
        int root2 = find(j);

        if(root1 == root2){
            return;
        }

        if(rank[root1] > rank[root2]){
            parent[root2] = root1;
            rank[root1]+=rank[root2];
        }else{
            parent[root1] = root2;
            rank[root2]+=rank[root1];
        }
    }
}
