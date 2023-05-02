public class Main {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        System.out.println(splitArray(nums, 3));
    }

    // 7,2,5,10,8 - 3
    public static int splitArray(int[] nums, int k) {
        int l = 0, r = 0;

        for (int i = 0; i < nums.length; i++){
            l = Math.max(l, nums[i]);
            r += nums[i];
        }

        while (l <= r) {
            var mid = l + ((r - l) / 2);

            if (canSplit(nums, mid, k)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private static boolean canSplit(int[] nums, int mid, int m) {
        int curSum = 0;
        int subarray = 1;

        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];

            if (curSum > mid) {
                subarray+=1;
                curSum = nums[i];
            }

            if (subarray > m){
                return false;
            }
        }

        return true;
    }
}