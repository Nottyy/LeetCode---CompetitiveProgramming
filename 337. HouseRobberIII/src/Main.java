public class Main {
    public static void main(String[] args) {
        var node4 = new TreeNode(4);
        var node1 = new TreeNode(1);
        var node2 = new TreeNode(2);
        var node3 = new TreeNode(3);
        node4.left = node1;
        node1.left = node2;
        node2.left = node3;
        System.out.println(rob(node4));
    }

    public static int rob(TreeNode root) {
        var res = DFS(root);
        return Math.max(res[0], res[1]);
    }


    public static int[] DFS(TreeNode root) {
        if (root != null) {
            var left = DFS(root.left);
            var right = DFS(root.right);
            var l = root.val + left[1] + right[1];
            var r = Math.max(left[0], left[1]) + Math.max(right[0],right[1]);
            return new int[]{l, r};
        }
        return new int[]{0, 0};
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