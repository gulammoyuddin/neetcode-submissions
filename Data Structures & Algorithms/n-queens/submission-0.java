class Solution {
    List<List<String>> hs;
    public List<List<String>> solveNQueens(int n) {
        hs = new ArrayList<List<String>>();
        makeBoard(new char[n][n], 0);
        return hs;
    }
    public char[][] placeQueen(char[][] board, int i, int j){
        int n = board.length;
        char[][] copy = new char[n][n];
        for(int a =0; a<n; a++){
            copy[a] = new char[n];
            System.arraycopy(board[a], 0, copy[a], 0, n);
        }

        copy[i][j] = 'Q';
        for(int a=0; a<n; a++){
            if(a != i) copy[a][j] = '.';
        }
        for(int a=0; a<n; a++){
            if(a != j) copy[i][a] = '.';
        }
        int x = i+1, y = j+1;
        while(x >= 0 && x < n && y >= 0 && y < n){
            if(!(x==i && y==j)) copy[x][y] = '.';
            x++;
            y++;
        }
        x = i-1;
        y = j-1;
        while(x >= 0 && x < n && y >= 0 && y < n){
            if(!(x==i && y==j)) copy[x][y] = '.';
            x--;
            y--;
        }
        x = i+1;
        y = j-1;
        while(x >= 0 && x < n && y >= 0 && y < n){
            if(!(x==i && y==j)) copy[x][y] = '.';
            x++;
            y--;
        }
        x = i-1;
        y = j+1;
        while(x >= 0 && x < n && y >= 0 && y < n){
            if(!(x==i && y==j)) copy[x][y] = '.';
            x--;
            y++;
        }
        return copy;
    }

    public void makeBoard(char[][] board, int q){
        int n = board.length;
        // printBoard(board);
        // System.out.println(q);
        if(q == n){
            List<String> ls = new ArrayList<String>();
            for(int i=0; i<n; i++){
                ls.add(new String(board[i]));
            }
            hs.add(ls);
            return;
        }

        for(int j=0; j<n; j++){
            if(board[q][j] == 0){
                makeBoard(placeQueen(board, q, j), q+1);
            }
        }
    }
    public void printBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            System.out.print(new String(board[i]));
            System.out.print(", ");
        }
        System.out.println("");
    }
}
