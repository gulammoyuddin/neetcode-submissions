class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;
        ArrayDeque<Integer> ad = new ArrayDeque<Integer>();
        int[][] mins = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    ad.offer((i*m)+j);
                    mins[i][j] = 0;
                }else if(grid[i][j]==1){
                    mins[i][j] = Integer.MAX_VALUE;
                }else{
                    mins[i][j] = -1;
                }
            }
        }
        // printMatrix(mins);
        while(!ad.isEmpty()){
            int h = ad.poll();
            int a = h/m;
            int b = h % m;
            if((a-1)>-1 && mins[a-1][b] > (mins[a][b]+1)){
                mins[a-1][b] =  mins[a][b]+1;
                ad.offer(((a-1)*m)+b);
            }

            if(b+1<m && mins[a][b+1] >  (mins[a][b]+1)){
                mins[a][b+1] =  mins[a][b]+1;
                ad.offer((a*m)+b+1);
            }

            if(a+1<n && mins[a+1][b] >   (mins[a][b]+1)){
                mins[a+1][b] =  mins[a][b]+1;
                ad.offer(((a+1)*m)+b);
            }

            if(b-1>-1 &&    mins[a][b-1] >  (mins[a][b]+1)){
                mins[a][b-1] =  mins[a][b]+1;
                ad.offer((a*m)+b-1);
            }
                    // printMatrix(mins);
        }
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(mins[i][j]==Integer.MAX_VALUE) return -1;
                if(mins[i][j]<Integer.MAX_VALUE && max<mins[i][j]){
                    max=mins[i][j];
                    // System.out.println(max);
                }
            }
        }
        return max;
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
