public class Main {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };


        System.out.println(searchMatrix(matrix, 1));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        var lenRows = matrix.length;
        var lenCols = matrix[0].length;
        var left = 0;
        var right = lenRows * lenCols;


        while (left <= right) {
            var mid = left + ((right - left) / 2);

            var remainder = mid % lenCols;
            int x;
            int y;
            if (mid == 0){
                x = 0;
                y = 0;
            }
            else{
                x = remainder == 0 ? (mid / lenCols) - 1 : mid / lenCols;
                y = remainder == 0 ? lenCols - 1 : remainder - 1;
            }

            if (target > matrix[x][y]) {
                left = mid + 1;
            } else if (target < matrix[x][y]) {
                right = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}