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
        System.out.println(kthSmallest(node10, 2));
    }

    public static int counter = 1;
    public static int val = -1;

    public static int kthSmallest(TreeNode root, int k) {
        DFS(root, k);
        return val;
    }

    private static void DFS(TreeNode root, int k) {
        if (root != null) {
            kthSmallest(root.left, k);
            if (counter == k) {
                val = root.val;
            }
            counter++;
            kthSmallest(root.right, k);
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