public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(1);
        var node2 = new TreeNode(2);
        var node3 = new TreeNode(3);
        var node4 = new TreeNode(33);
        var node5 = new TreeNode(44);
        var node6 = new TreeNode(55);

        node1.right = node2;
        node1.left = node4;
        node2.left = node3;
        //node3.left = node5;
//        node5.right = node6;

        System.out.println(isBalanced(node1));
    }

    public static boolean isBalanced(TreeNode root) {
       return DFS(root) >= 0;
    }

    private static int DFS(TreeNode root) {
        if (root != null){
            int left = 0;
            int right = 0;

            if (root.left != null){
                left = DFS(root.left) + 1;
            }

            if (root.right != null){
                right = DFS(root.right) + 1;
            }

            if (left < 0 || right < 0){
                return Integer.MIN_VALUE;
            }

            var diff = left > right ? left - right : right - left;
            if (diff > 1){
                return Integer.MIN_VALUE;
            }
            else{
                return Math.max(left,right);
            }
        }
        else{
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