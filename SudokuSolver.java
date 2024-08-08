public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board ={ {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if (solve(board)){
            display(board);
        }
        else {
            System.out.println("not possible.");
        }
    }

    static boolean solve(int[][] board){
        int row = -1;
        int col = -1;

        boolean empty = false;

        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board.length ; j++) {
                if (board[i][j] == 0){
                    row = i;
                    col = j;
                    empty = true;  // found an empty place.
                    break;
                }
            }
            if (empty){
                break;
            }
        }

        if (!empty){
            return true;  // if there are no empty place.
        }

            // placing numbers one by one.
            for (int num = 1; num <=9; num++) {
                if (isSafe(board,row,col,num)){
                    board[row][col] = num;

                    if (solve(board)){
                        return true;
                    }
                    else {
                        // backtracking.
                        board[row][col] =0;
                    }

                }

            }
        return false;
    }

    static void display(int[][] board){
        for (int[] row :board) {
            for ( int num : row){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    static boolean isSafe(int[][] board, int row,int col,int num){
        // check for the row
        for (int i = 0; i < board.length ; i++) {
            if (board[row][i] == num){
                return false;
            }
        }

        // for column
        for (int i = 0; i < board.length ; i++) {
            if (board[i][col] == num){
                return false;
            }
        }

        // for the box
        int sqrt = (int)Math.sqrt(board.length);
        int rStart = row - row%sqrt;
        int cStart = col - col%sqrt;

        for (int i = rStart; i <rStart+sqrt ; i++) {
            for (int j = cStart; j < cStart+sqrt; j++) {
                if (board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }
}

