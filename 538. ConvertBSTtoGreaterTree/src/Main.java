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
        node20.left = new TreeNode(15);

        convertBST(node10);
    }

    public static TreeNode convertBST(TreeNode root) {
        return DFS(root);
    }
    public static int curSum = 0;
    public static TreeNode DFS(TreeNode root) {
        if (root != null) {
            DFS(root.right);
            var tmp = root.val;
            root.val += curSum;
            curSum += tmp;
            DFS(root.left);

            return root;
        }
        else{
            return null;
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