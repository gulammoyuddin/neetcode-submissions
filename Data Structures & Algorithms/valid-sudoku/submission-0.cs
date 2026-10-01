public class Solution {
    public bool IsValidSudoku(char[][] board) {
        List<HashSet<char>> rows = new List<HashSet<char>>{
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>()
        };
        List<HashSet<char>> cols = new List<HashSet<char>>{
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>()
        };
        List<HashSet<char>> box = new List<HashSet<char>>{
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>(),
            new HashSet<char>()
        };

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int boxId = getBoxId(i,j);
                if(!rows[i].Contains(board[i][j])
                   && !cols[j].Contains(board[i][j])
                   && !box[boxId].Contains(board[i][j])    
                ){
                    rows[i].Add(board[i][j]);
                    cols[j].Add(board[i][j]);
                    box[boxId].Add(board[i][j]);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public static int getBoxId(int x, int y){
        if(0 <= x && x <= 2){
            if(0 <= y && y <= 2){
                return 0;
            }else if(3 <= y && y <= 5){
                return 1;
            }else{
                return 2;
            }
        }else if(3 <= x && x <= 5){
            if(0 <= y && y <= 2){
                return 3;
            }else if(3 <= y && y <= 5){
                return 4;
            }else{
                return 5;
            }
        }else{
            if(0 <= y && y <= 2){
                return 6;
            }else if(3 <= y && y <= 5){
                return 7;
            }else{
                return 8;
            }
        }
    }
}
