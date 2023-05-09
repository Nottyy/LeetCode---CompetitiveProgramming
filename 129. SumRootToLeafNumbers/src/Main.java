public class Main {
    public static void main(String[] args) {
        var node10 = new TreeNode(10);
        var node20 = new TreeNode(20);
        var node30 = new TreeNode(30);
        var node5 = new TreeNode(5);
        var node7 = new TreeNode(7);

        node10.left = node5;
        node10.right = node20;
        node20.right = node30;
        node5.right = node7;
        node7.right = new TreeNode(8);
        node7.left = new TreeNode(6);

        System.out.println(sumNumbers(node20));
    }

    public static int totalSum = 0;

    public static int sumNumbers(TreeNode root) {
        DFS(root, 0);
        return totalSum;
    }

    private static void DFS(TreeNode root, int curSum) {
        if (root != null) {

            var digits = String.valueOf(root.val).length();
            int power = 1;
            for (int i = 0; i < digits; i++){
                power *= 10;
            }

            curSum = (curSum * power) + root.val;

            if (root.left == null && root.right == null) {
                totalSum += curSum;
            } else {
                DFS(root.left, curSum);
                DFS(root.right, curSum);
            }
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}