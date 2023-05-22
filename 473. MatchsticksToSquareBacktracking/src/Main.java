import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] matchsticks = {1,1, 1,1,1,1,1,1,1,1,1,1,1,1,102};

        System.out.println(makesquare(matchsticks));
    }

    public static boolean makesquare(int[] matchsticks) {
        if (Arrays.stream(matchsticks).sum() % 4 != 0) {
            return false;
        }

        int side = Arrays.stream(matchsticks).sum() / 4;
        Integer[] result = new Integer[4];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        if (side < matchsticks[0]) {
            return false;
        }
        Arrays.sort(matchsticks);

        for (int left = 0, right = matchsticks.length - 1; left < right; left++, right--) {
            int temp = matchsticks[left];
            matchsticks[left]  = matchsticks[right];
            matchsticks[right] = temp;
        }

        return Backtracking(matchsticks, side, result, 0);
    }

    private static boolean Backtracking(int[] matchsticks, int side, Integer[] sides, int index) {
        if (index == matchsticks.length) {
            return true;
        }

        var curVal = matchsticks[index];

        for (int j = 0; j < 4; j++) {
            var curSideResult = sides[j];

            if (curVal + curSideResult <= side) {
                sides[j] += curVal;
                if (Backtracking(matchsticks, side, sides, index + 1)) {
                    return true;
                }
                sides[j] -= curVal;
            }
        }

        return false;
    }
}