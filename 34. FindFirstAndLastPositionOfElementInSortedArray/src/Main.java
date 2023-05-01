import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 8, 8, 8, 8, 10};
        var res = searchRange(nums, 11);
        String result = Arrays.stream(res)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static int[] searchRange(int[] nums, int target) {
        var first = BinarySearchFirst(nums, target);
        var second = BinarySearchLast(nums, target);

        int[] res = {first, second};
        return res;
    }

    public static int BinarySearchLast(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        var found = false;

        while (left <= right){
            var mid = left + ((right - left) / 2);

            if (target > nums[mid]){
                left = mid + 1;
            }
            else if (target < nums[mid]){
                right = mid - 1;
            }
            else{
                found = true;
                left = mid + 1;
            }
        }

        return found ? right : -1;
    }

    public static int BinarySearchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        var found = false;

        while (left <= right) {
            mid = left + ((right - left) / 2);

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]){
                right = mid - 1;
            }
            else{
                found = true;
                right = mid - 1;
            }
        }
        return found ? left : -1;
    }
}