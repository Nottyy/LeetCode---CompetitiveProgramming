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
        node30.right = node7;
        node7.right = new TreeNode(8);
        node7.left = new TreeNode(6213);

        System.out.println(findBottomLeftValue(node10));;
    }

    public static int leftmostVal;
    public static int maxLevel = 0;
    
    public static int findBottomLeftValue(TreeNode root) {
        leftmostVal = root.val;
        
        DFS(root, 0);
        
        return leftmostVal;
    }

    private static void DFS(TreeNode root, int level) {
        if (root != null){
            DFS(root.left, level + 1);
            DFS(root.right, level + 1);
            if (level > maxLevel){
                maxLevel = level;
                leftmostVal = root.val;
            }
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