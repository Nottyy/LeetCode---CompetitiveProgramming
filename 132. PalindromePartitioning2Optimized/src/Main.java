public class Main {
    public static void main(String[] args) {
        minCut("aab");
    }

    public static int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n + 1][n + 1];
        computeAllPals(isPal, s.toCharArray());

        return 0;
    }

    private static void computeAllPals(boolean[][] isPal, char[] A) {
        int n = A.length;
        for (int i = n; i >= 1; i--) {
            isPal[i][i - 1] = true;
            isPal[i][i] = true;

            for (int j = i + 1; j <= n; j++) {
                if (A[i - 1] == A[j - 1]){
                    isPal[i][j] = isPal[i + 1][j - 1];
                }
                else{
                    isPal[i][j] = false;
                }
            }
        }
    }
}