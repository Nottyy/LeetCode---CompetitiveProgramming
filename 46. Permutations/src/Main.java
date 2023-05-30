import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    }

    public  List<List<Integer>> ans = new ArrayList<>();

    public  List<List<Integer>> permute(int[] nums) {
        HashSet<Character> set = new HashSet<>();

        Backtracking(nums, set, "");

        return ans;
    }

    private  void Backtracking(int[] nums, HashSet<Character> set, String result) {
        if (result.length() == nums.length) {
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < result.length(); i++){
                arr.add(Character.getNumericValue(result.charAt(i)));
            }
            ans.add(new ArrayList<>(arr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains((char)nums[i])) {
                continue;
            } else {
                var ch = (char)nums[i];

                set.add(ch);
                result += nums[i];
                Backtracking(nums, set, result);
                result = result.substring(0, result.length() - 1);
                set.remove(ch);
            }
        }
    }
}