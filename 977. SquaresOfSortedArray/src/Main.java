public class Main {
    public static void main(String[] args) {
        int[] nums = {-44, -33, -3, -2, 0, 4, 5, 5};
        var s = sortedSquares(nums);
        for (int i =0; i< s.length; i++){
            System.out.println(s[i]);
        }
    }

    public static int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] ans = new int[nums.length];
        int counter = nums.length - 1;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                ans[counter] = nums[left] * nums[left];
                left++;
            } else {
                ans[counter] = nums[right] * nums[right];
                right--;
            }

            counter--;
        }

        return ans;
    }
}