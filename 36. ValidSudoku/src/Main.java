import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
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

        return rowsChecked && colsChecked && squaresChecked;
    }

    private static boolean PopulateSquares(HashSet<Integer>[] squares, char[][] board) {
        var counter = 0;
        for (int p = 0; p < 9; p += 3) {
            for (int k = 0; k < 9; k += 3) {

                squares[counter] = new HashSet<>();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {

                        if (board[i + p][j + k] != '.') {
                            var val = Character.getNumericValue(board[i + p][j + k]);

                            if (squares[counter].contains(val)) {
                                return false;
                            } else {
                                squares[counter].add(val);
                            }
                        }
                    }
                }
                counter++;
            }
        }

        return true;
    }

    private static boolean PopulateCols(HashSet<Integer>[] cols, char[][] board) {
        for (int i = 0; i < 9; i++) {
            cols[i] = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                if (AddValuesToSet(cols, board, j, i, false)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean AddValuesToSet(HashSet<Integer>[] set, char[][] board, int i, int j, boolean inRow) {
        if (board[i][j] != '.') {
            var val = Character.getNumericValue(board[i][j]);

            if (set[inRow ? i : j].contains(val)) {
                return true;
            } else {
                set[inRow ? i : j].add(val);
            }
        }
        return false;
    }

    private static boolean PopulateRows(HashSet<Integer>[] rows, char[][] board) {
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            for (int j = 0; j < 9; j++) {

                if (AddValuesToSet(rows, board, i, j, true)) {
                    return false;
                }
            }
        }

        return true;
    }
}