public class Main {
    public static void main(String[] args) {
        int[] arr = {200,3,140,20,10};
        System.out.println(rob(arr));
    }

    public static int rob(int[] nums) {
        var len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        var first = solve(nums, 0, len - 1);
        var sec = solve(nums, 1, len);
        return Math.max(first,sec);
    }


    private static int solve(int[] nums, int start, int len) {
        int[] x = new int[2];
        boolean usedLast = false;

        for (int i = start; i < len; i++) {
            var l = nums[i] + x[1];
            var r = Math.max(x[0], x[1]);
            x[0] = l;
            x[1] = r;
        }

        return Math.max(x[0], x[1]);
    }
}