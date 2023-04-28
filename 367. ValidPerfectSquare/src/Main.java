public class Main {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1){
            return true;
        }

        long left = 0;
        long right = num / 2;

        while (left <= right){
            var mid = left + ((right - left) / 2);
            long val = mid * mid;

            if (val > num){
                right = mid - 1;
            }
            else if (val < num){
                left = mid + 1;
            }
            else {
                return true;
            }
        }

        return false;
    }
}