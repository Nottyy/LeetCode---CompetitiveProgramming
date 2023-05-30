import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var s = permuteUnique(new int[] {-1,3,3});
    }

    public static List<List<Integer>> ans = new ArrayList<>();
    public static HashSet<String> setStrings = new HashSet<>();

    public static List<List<Integer>> permuteUnique(int[] nums) {
        HashSet<Integer> setIndeces = new HashSet<>();

        Backtracking(nums, setIndeces, "", 0);

        return ans;
    }

    private static void Backtracking(int[] nums, HashSet<Integer> set, String result, Integer index) {
        if (index == nums.length && setStrings.contains(result) == false) {
            System.out.println(result);
            setStrings.add(result);
            String[] msg = result.split(",");
            List<Integer> curRes = new ArrayList<>();
            for (int i = 1; i < msg.length; i++){
                curRes.add(Integer.parseInt(msg[i]));
            }

            ans.add(curRes);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(i)) {
                continue;
            } else {
                var cur = String.valueOf(nums[i]);
                set.add(i);
                result += "," + cur;
                Backtracking(nums, set, result, index + 1);

                if (cur.length() == 1){
                    result = result.substring(0, result.length() - 2);
                }
                else{
                    result = result.substring(0, result.length() - 3);
                }
                set.remove(i);
            }
        }
    }
}
