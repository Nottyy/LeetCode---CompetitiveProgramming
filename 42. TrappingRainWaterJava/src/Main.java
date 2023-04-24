public class Main {
    public static void main(String[] args) {
        var height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        var leftMax = new int[height.length];
        leftMax[0] = height[0];
        var rightMax = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < leftMax.length; i++) {
            if (height[i] > leftMax[i - 1]) {
                leftMax[i] = height[i];
            } else {
                leftMax[i] = leftMax[i - 1];
            }
        }

        for (int i = height.length - 1 - 1; i >= 0; i--) {
            if (height[i] > rightMax[i + 1]) {
                rightMax[i] = height[i];
            } else {
                rightMax[i] = rightMax[i + 1];
            }
        }

        var result = 0;

        for (int i = 0; i < height.length; i++) {
            var min = Math.min(leftMax[i], rightMax[i]);
            if (height[i] < min){
                result += min - height[i];
            }
        }

        return result;
    }
}