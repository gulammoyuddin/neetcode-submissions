class Solution {
    public void islandsAndTreasure(int[][] grid) {
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    fillLand(grid, i, j);
                }
            }
        }
    }
    public void fillLand(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        int inf = Integer.MAX_VALUE;
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        ad.offer((i*m)+j);

        while(!ad.isEmpty()){
            int h = ad.poll();
            int a = h/m;
            int b = h % m;
            if((a-1)>-1 && grid[a-1][b] > (grid[a][b]+1)){
                grid[a-1][b] = (grid[a][b]+1);
                ad.offer(((a-1)*m)+b);
            }

            if(b+1<m && grid[a][b+1] > (grid[a][b]+1)){
                grid[a][b+1] = (grid[a][b]+1);
                ad.offer((a*m)+b+1);
            }

            if(a+1<n && grid[a+1][b] > (grid[a][b]+1)){
                grid[a+1][b] = (grid[a][b]+1);
                ad.offer(((a+1)*m)+b);
            }

            if(b-1>-1 && grid[a][b-1] > (grid[a][b]+1)){
                grid[a][b-1] = (grid[a][b]+1);
                ad.offer((a*m)+b-1);
            }
        }
    }
}
