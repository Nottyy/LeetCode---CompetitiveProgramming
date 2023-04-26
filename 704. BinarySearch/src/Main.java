public class Main {
    public static void main(String[] args) {
//        int[] nums = new int[50];
//        for (int i = 0; i < nums.length; i++){
//            nums[i] = i * 2;
//        }
        int[] nums = {-1, 0, 3, 5};

        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {
        return BinarySearch(nums, target, 0, nums.length - 1);
    }

    public static int BinarySearch(int[] nums, int target, int left, int right) {
        if (left <= right) {
            int middleIndex = (left + right) / 2;
            int middle = nums[middleIndex];

            if (target > middle) {
                return BinarySearch(nums, target, middleIndex + 1, right);
            } else if (target < middle) {
                return BinarySearch(nums, target, left, middleIndex - 1);
            } else {
                return middleIndex;
            }
        }

        return -1;
    }
}