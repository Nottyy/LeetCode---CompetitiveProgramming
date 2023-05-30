import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var ans = permute(new int[]{1,2,3});
        for (var s: ans){
            var res = s.stream().map(Object::toString).collect(Collectors.toList());
            System.out.println(res);
        }
    }

    public static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        Backtracking(nums, set, result);

        return ans;
    }

    private static void Backtracking(int[] nums, HashSet<Integer> set, List<Integer> result) {
        if (result.size() == nums.length) {
            ans.add(new ArrayList<>(result));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            } else {
                set.add(nums[i]);
                result.add(nums[i]);
                Backtracking(nums, set, result);
                result.remove(result.size() - 1);
                set.remove(nums[i]);
            }
        }
    }
}