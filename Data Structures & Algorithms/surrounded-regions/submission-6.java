class Solution {
    int[] parent;
    int[] rank;
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;

        parent = new int[n*m];
        rank = new int[n*m];

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O'){
                    parent[(i*m)+j] = (i*m)+j;
                    rank[(i*m)+j] = 1;
                }
                if(board[i][j] == 'X'){
                    parent[(i*m)+j] = -1;
                }
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i+1<n && board[i][j] == 'O' && board[i+1][j] == 'O'){
                    union((i*m)+j, ((i+1)*m)+j);
                }
                if(j+1<m && board[i][j] == 'O' && board[i][j+1] == 'O'){
                    union((i*m)+j, ((i)*m)+j+1);
                }
            }
        }

        // printMatrix(n,m);

        HashSet<Integer> hs = new HashSet<>();

        for(int i = 0; i<(n*m); i++){
            if(parent[i] == -1) continue;
            hs.add(find(i));
        }

        // printMatrix(n,m);

        for(int i = 0; i<(n*m); i++){
            if(parent[i] == -1) continue;
            int a = i/m, b = i%m;

            if(a == 0 || a == n-1 || b == 0 || b == m-1){
                if(hs.contains(parent[i])) hs.remove(parent[i]);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == 'O' && hs.contains(parent[(i*m)+j])){
                    board[i][j] = 'X';
                }
            }
        }
        
    }

    public void printMatrix(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int c = (i*m) + j;
                System.out.print(parent[c] + ", ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int find(int i){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j){
        int root1 = find(i), root2 = find(j);

        if(root1 == root2){
            return;
        }

        if(rank[root1] > rank[root2]){
            parent[root2] = root1;
            rank[root1]++;
        }else{
            parent[root1] = root2;
            rank[root2]++;
        }
    }
}
