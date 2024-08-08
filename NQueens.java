public class NQueens {
    public static void main(String[] args) {
        int n = 8;
        boolean[][] board = new boolean[n][n];
        System.out.println(nQueens(board,0));
    }

    static int nQueens(boolean[][] board,int row){
        if (row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count =0;

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board,row,i)){
                board[row][i] = true;  // if we place the queen then it becomes true.
                count += nQueens(board,row+1); // check for the next row.
                board[row][i] = false;  // BACKTRACKING.
            }
        }
        return count;
    }

    //check if we can place the queen or not.
    static boolean isSafe(boolean[][] board,int row,int col) {
        // check vertically
        for (int i = row; i >=0 ; i--) {
            if (board[i][col]){
                return false;
            }
        }

        // check left diagonally.
        int left = Math.min(row,col);  // find how many diagonal elements to be checked.
        for (int i = 1; i <= left; i++) {
            if (board[row-i][col-i]){
                return false;
            }
        }

        // check right diagonally.
        int right = Math.min(row, board.length-col-1);
        for (int i = 1; i <= right ; i++) {
            if (board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    // print the board
    static void display(boolean[][] board) {
        for (boolean[] row: board) {
            for (boolean element : row) {
                if (element){
                    System.out.print("Q ");
                }
                else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
}
