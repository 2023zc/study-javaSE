package leetcode;

//leetcode刷题:https://leetcode.cn/problems/word-search/
public class Path_In_Matrix {

    private String Word;
    private boolean[][] book;



    public boolean exist(char[][] board, String word) {
        Word=word;
        book = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    book[i][j] = true;
                    if(dfs(board, i, j, 1)) return true;
                    book[i][j]=false;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int startx, int starty, int deepth) {
        if(deepth==Word.length()){
            return true;
        }
        int[] de_x={0,-1,0,1};
        int[] de_y={-1,0,1,0};  //方向数组
        //4个方向
        for(int i=0;i<4;i++){
            int newx=startx+de_x[i];
            int newy=starty+de_y[i];
            if(newx>=0&&newx<board.length&&newy>=0&&newy<board[0].length){
                    if(!book[newx][newy]&&board[newx][newy]==Word.charAt(deepth)){
                    book[newx][newy]=true;
                    if(dfs(board,newx,newy,deepth+1)) return true;
                    //回溯
                    book[newx][newy]=false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        Path_In_Matrix path_in_matrix = new Path_In_Matrix();
        System.out.println(path_in_matrix.exist(board, word));


    }
}
