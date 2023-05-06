public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(10);
        var node2 = new TreeNode(20);

        node1.right = node2;
        insertIntoBST(node1, 5);
        var s = 4;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }

        if (val > root.val){
            if (root.right != null){
                root.right = insertIntoBST(root.right, val);
            }
            else{
                root.right = new TreeNode(val);
            }
        }
        else{
            if (root.left != null){
                root.left = insertIntoBST(root.left, val);
            }
            else{
                root.left = new TreeNode(val);
            }
        }

        return root;
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