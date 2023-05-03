public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(10);
        var node2 = new TreeNode(15);
        var node3 = new TreeNode(1);
        var node4 = new TreeNode(10);
        var node5 = new TreeNode(2);
        var node6 = new TreeNode(3);
        var node7 = new TreeNode(33);
        var node8 = new TreeNode(333);

        node1.left = node2;
        node1.left = node3;

        node3.right = node5;
        node3.left = node4;
        node5.right = node6;
        node4.left = node7;

        node6.left = node8;

        diameterOfBinaryTree(node1);
        System.out.println(max);
    }

    static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        calculateDiameterDFS(root);

        return max;
    }

    private static int calculateDiameterDFS(TreeNode root) {
        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = calculateDiameterDFS(root.left) + 1;
        }

        if (root.right != null) {
            right = calculateDiameterDFS(root.right) + 1;
        }

        if (left + right > max) {
            max = left + right;
        }

        return Math.max(left, right);
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