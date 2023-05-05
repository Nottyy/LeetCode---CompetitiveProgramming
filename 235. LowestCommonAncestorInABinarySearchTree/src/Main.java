public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val > p.val && root.val < q.val) || (root.val < p.val && root.val > q.val)){
            return root;
        }

        if (root.val == p.val || root.val == q.val){
            return root;
        }

        return root.val > p.val ? lowestCommonAncestor(root.left, p, q) : lowestCommonAncestor(root.right,p,q);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}