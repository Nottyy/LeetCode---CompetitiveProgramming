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
        node30.right = new TreeNode(1111);
        node30.left = new TreeNode(25);

        System.out.println(goodNodes(node10));
    }

    public static int goodNodes(TreeNode root) {
        return DFS(root, root.val);
    }

    private static int DFS(TreeNode root, int val) {
        if (root != null) {
            int goodNode = 0;
            if (root.val >= val){
                goodNode = 1;
                val = root.val;
            }

            var left = DFS(root.left, val);
            var right = DFS(root.right, val);
            return left + right + goodNode;
        } else {
            return 0;
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