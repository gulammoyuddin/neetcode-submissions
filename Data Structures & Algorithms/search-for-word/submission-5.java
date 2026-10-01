class Solution {
    private boolean doesExist = false;
    public boolean exist(char[][] board, String word) {
        int x = board.length;
        int y = board[0].length;
        for(int i=0; i<x && !doesExist; i++){
            for(int j=0; j<y && !doesExist; j++){
                if(word.charAt(0) == board[i][j]){
                    int[][] visMap = new int[x][y];
                    findNext(i, j, board, visMap, word, 1);
                }
            }
        }
        return doesExist;
    }
    public void findNext(int a, int b, char[][] board,int[][] visMap , String word, int charIndex){
        if(word.length() == charIndex){
            doesExist = true;
            return;
        }
        visMap[a][b] = 1;
        System.out.println("a:="+a);
        System.out.println("b:="+b);
        System.out.println("char:="+word.charAt(charIndex));
        if(a-1 >=0 && board[a-1][b]==word.charAt(charIndex) && visMap[a-1][b] == 0)
        findNext(a-1, b, board, visMap, word, charIndex+1);
        
        if(a+1 < board.length && board[a+1][b]==word.charAt(charIndex) && visMap[a+1][b] == 0)
        findNext(a+1, b, board, visMap, word, charIndex+1);
        
        if(b-1 >=0 && board[a][b-1]==word.charAt(charIndex) && visMap[a][b-1] == 0)
        findNext(a, b-1, board, visMap, word, charIndex+1);

        if(b+1 < board[0].length && board[a][b+1]==word.charAt(charIndex) && visMap[a][b+1] == 0)
        findNext(a, b+1, board, visMap, word, charIndex+1);
        visMap[a][b] = 0;
    }
}
