class Solution {
    HashSet<Integer> atl, pac;
    int n,m;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        pac = new HashSet<Integer>();
        atl = new HashSet<Integer>();
        for(int i = 0; i < m; i++) dfs(heights, 0, i, pac);
        for(int i = 0; i < n; i++) dfs(heights, i, 0, pac);
        for(int i = 0; i < m; i++) dfs(heights, n-1, i, atl);
        for(int i = 0; i < n; i++) dfs(heights, i, m-1, atl);

        List<List<Integer>> res = new ArrayList<>();


        for(int i : pac){
            if(atl.contains(i)){
                List<Integer> ar = new ArrayList<>();
                ar.add(i/m);
                ar.add(i%m);
                res.add(ar);
            }
        }

        return res;
    }

    public void dfs(int[][] hg, int i, int j, HashSet<Integer> hs){
        hs.add((i*m)+j);
        if((i-1)>-1 && !hs.contains(((i-1)*m)+j) && hg[i-1][j] >= hg[i][j]) dfs(hg, i-1, j, hs);
        if((i+1)<n && !hs.contains(((i+1)*m)+j) && hg[i+1][j] >= hg[i][j]) dfs(hg, i+1, j, hs);
        if((j-1)>-1 && !hs.contains((i*m)+j-1) && hg[i][j-1] >= hg[i][j]) dfs(hg, i, j-1, hs);
        if((j+1)<m && !hs.contains(((i)*m)+j+1) && hg[i][j+1] >= hg[i][j]) dfs(hg, i, j+1, hs);
    }
    public void printMatrix(int[][] grid){
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                System.out.print(grid[i][j]+", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
