import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        String[] nums = {"01", "00"};
        var res = findDifferentBinaryString(nums);
        System.out.println(res);
    }

    public static String result;

    public static String findDifferentBinaryString(String[] nums) {
        var set = new HashSet<String>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Backtracking(set, 0, "");

        return result;
    }

    private static void Backtracking(HashSet<String> set, int counter, String str) {
        if (counter == set.size()) {
            if (!set.contains(str)) {
                result = str;
            }
        }
        else{
            if (result == null){
                Backtracking(set, counter + 1, str + "0");
            }
            if (result == null){
                Backtracking(set, counter + 1, str + "1");
            }
        }
    }
}