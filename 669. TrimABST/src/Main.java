public class Main {
    public static void main(String[] args) {
        var node10 = new TreeNode(10);
        var node20 = new TreeNode(20);
        //var node30 = new TreeNode(30);
        var node5 = new TreeNode(5);
        var node7 = new TreeNode(7);

        node10.left = node5;
        node10.right = node20;
        //node20.right = node30;
        node5.right = node7;
//        node7.right = new TreeNode(8);
//        node7.left = new TreeNode(6);

        var newRoot = new TreeNode();
        var n = trimBST(node10, 10, 20);

    }

    public static TreeNode trimBST(TreeNode root, int low, int high) {
        if (root != null) {
            if (root.val >= low && root.val <= high) {
                if (root.left != null){
                    root.left = trimBST(root.left, low, high);
                }

                if (root.right != null){
                    root.right = trimBST(root.right, low, high);
                }
            }
            else{
                if (root.val < low){
                    root = trimBST(root.right, low, high);
                }
                else{
                    root = trimBST(root.left, low, high);
                }
            }
        }

        return root;
    }

//    private static void DFS(TreeNode root) {
//        if (root != null) {
//
//        }
//    }

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