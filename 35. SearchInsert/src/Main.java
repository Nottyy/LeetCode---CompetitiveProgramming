public class Main {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 10};
        System.out.println(searchInsert(nums, 98));
    }

    // 0 , 2, 5, 10 --- 8
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middle = start + ((end - start) / 2);

            if (target < nums[middle]) {
                end = middle - 1;
            } else if (target > nums[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }

        return start;
    }
}