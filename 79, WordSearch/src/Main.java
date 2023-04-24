import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'E', 'S'},
                {'A', 'D', 'E', 'E'}};
        var word = "ABCESEEEFS";

        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        var result = false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(boolean row[]: visited){
            Arrays.fill(row, false);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    result = Backtracking(board, visited, word, 0, i, j);

                    if (result) {
                        return true;
                    }

                    for(boolean row[]: visited){
                        Arrays.fill(row, false);
                    }
                }
            }
        }

        return false;
    }

    public static boolean Backtracking(char[][] board, boolean[][] visited, String word, int count, int row, int col) {
        if (word.length() == count) {
            return true;
        }

        if (row < 0 || row >= board.length) {
            return false;
        }

        if (col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col]){
            return false;
        }

        if (board[row][col] == word.charAt(count) && visited[row][col] == false) {
            visited[row][col] = true;
            var up = Backtracking(board, visited, word, count + 1, row - 1, col);
            var down = Backtracking(board, visited, word, count + 1, row + 1, col);
            var left = Backtracking(board, visited, word, count + 1, row, col - 1);
            var right = Backtracking(board, visited, word, count + 1, row, col + 1);
            visited[row][col] = false;

            return up || down || left || right;
        } else {
            return false;
        }
    }
}