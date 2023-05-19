import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,5,5,5,4,4,4,4,3,3,3,3};
        var s = makesquare(nums);
        System.out.println(s);
    }

    public static boolean result = false;

    public static boolean makesquare(int[] matchsticks) {
        List<Integer> arr = new ArrayList<>();
        Arrays.sort(matchsticks);

        Backtracking(matchsticks, arr, 0);

        return result;
    }

    private static void Backtracking(int[] matchsticks, List<Integer> arr, int index) {
        if (arr.size() == 4) {
            result = true;
            return;
        }

        for (int i = index + 1; i <= matchsticks.length; i++) {

            int sum = 0;
            if (arr.size() == 3) {
                for (int p = index; p < matchsticks.length; p++) {
                    sum += matchsticks[p];
                }

                if (sum == arr.get(0)) {
                    result = true;
                }

                return;
            }
            //        3 3 3 3 6 6
            int val = 0;

            for (int p = index; p < i; p++) {
                val += matchsticks[p];
            }

            while (arr.size() > index){
                arr.remove(arr.size() - 1);
            }
            arr.add(val);

            if (arr.size() != 1) {
                var counter = 0;
                var first = arr.get(0);
                for (int j = arr.size() - 1; j > 0; j--) {
                    var cur = arr.get(j);

                    if (cur > first) {
                        return;
                    } else if (cur < first) {
                        counter++;
                    }
                }

                if (counter > 1) {
                    arr.remove(arr.size() - 1);
                    return;
                }
            }

            Backtracking(matchsticks, arr, i);

            if (result != true) {
                arr.remove(arr.size() - 1);
            }
            else{
                return;
            }
        }
    }
}