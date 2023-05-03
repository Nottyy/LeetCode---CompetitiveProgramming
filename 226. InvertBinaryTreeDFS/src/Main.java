public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(4);
        var node2 = new TreeNode(5);
        var node3 = new TreeNode(1);
        var node4 = new TreeNode(10);
        var node5 = new TreeNode(2);
        var node6 = new TreeNode(3);

        node1.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.right = node6;

        var invNode = invertTree(node1);
        var s = 4;
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invertTree(root.right);
        newRoot.right = invertTree(root.left);

        return newRoot;
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