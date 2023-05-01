import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 3));
    }

    public static int splitArray(int[] nums, int k) {
        HashMap<List<String>, Integer> dp = new HashMap<List<String>, Integer>();
        return DFS(nums, dp, 0, k);
    }

    public static int DFS(int[] nums, HashMap<List<String>, Integer> dp, int i, int m) {
        if (m == 1) {
            var sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
            }
            return sum;
        }

        ArrayList<String> l = new ArrayList<>();
        l.add(String.valueOf(i));
        l.add(String.valueOf(m));

        if (dp.containsKey(l)){
            return dp.get(l);
        }

        var curSum = 0;
        var maxSum = 0;
        var res = Integer.MAX_VALUE;

        for(int j = i; j < nums.length; j++){
            curSum += nums[j];
            maxSum = Integer.max(curSum, DFS(nums, dp, j + 1, m - 1));
            res = Integer.min(res, maxSum);
            if (curSum > res){
                break;
            }
        }

        ArrayList<String> r = new ArrayList<>();
        r.add(String.valueOf(i));
        r.add(String.valueOf(m));

        dp.put(r, res);

        return res;
    }
}