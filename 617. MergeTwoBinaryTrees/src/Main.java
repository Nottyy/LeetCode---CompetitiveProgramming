public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(4);
        var node2 = new TreeNode(5);
        var node3 = new TreeNode(1);

        node1.right = node2;

        var st = mergeTrees(node1,node3);
        var s = 4;
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null){
            return null;
        }

        if (root1 != null && root2 == null){
            return root1;
        }
        else if(root1 == null && root2 != null){
            return root2;
        }
        else{
            int val1 = root1 == null ? 0 : root1.val;
            int val2 = root2 == null ? 0 : root2.val;

            var newRoot = new TreeNode(val1 + val2);

            newRoot.left = mergeTrees(root1.left, root2.left);
            newRoot.right = mergeTrees(root1.right, root2.right);

            return newRoot;
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