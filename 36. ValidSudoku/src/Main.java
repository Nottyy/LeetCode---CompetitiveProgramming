import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
 {'5','3','.','.','7','.','.','.','.'}
,{'6','.','.','1','9','5','.','.','.'}
,{'.','9','8','.','.','.','.','6','.'}
,{'8','.','.','.','6','.','.','.','3'}
,{'4','.','.','8','.','3','.','.','1'}
,{'7','.','.','.','2','.','.','.','6'}
,{'.','6','.','.','.','.','2','8','.'}
,{'.','.','.','4','1','9','.','.','5'}
,{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Integer>[] rows = new HashSet[9];
        HashSet<Integer>[] cols = new HashSet[9];
        HashSet<Integer>[] squares = new HashSet[9];

        var rowsChecked = PopulateRows(rows, board);
        var colsChecked = PopulateCols(cols, board);
        var squaresChecked = PopulateSquares(squares, board);
        return false;
    }

    private static boolean PopulateSquares(HashSet<Integer>[] squares, char[][] board) {
    }

    private static boolean PopulateCols(HashSet<Integer>[] cols, char[][] board) {
        for (int i = 0; i < 9; i++){
            cols[i] = new HashSet<>();
            for (int j = 0; j < 9; j++){

                if (board[j][i] != '.'){
                    var val = Character.getNumericValue(board[j][i]);

                    if (cols[i].contains(val)){
                        return false;
                    }
                    else{
                        cols[i].add(val);
                    }
                }
            }
        }

        return true;
    }

    private static boolean PopulateRows(HashSet<Integer>[] rows, char[][] board) {
        for (int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            for (int j = 0; j < 9; j++){

                if (board[i][j] != '.'){
                    var val = Character.getNumericValue(board[i][j]);

                    if (rows[i].contains(val)){
                        return false;
                    }
                    else{
                        rows[i].add(val);
                    }
                }
            }
        }

        return true;
    }
}