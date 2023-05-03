public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        return DFS(root) + 1;
    }

    private int DFS(TreeNode root) {
        int left = 0;
        int right = 0;

        if (root.left != null) {
            left = DFS(root.left) + 1;
        }

        if (root.right != null) {
            right = DFS(root.right) + 1;
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