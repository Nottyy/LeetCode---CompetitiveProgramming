public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(-2147483648);
        var node2 = new TreeNode(2147483647);
        node1.right = node2;

        System.out.println(isValidBST(node1));
    }

    public static boolean isValidBST(TreeNode root) {
        return DFS(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean DFS(TreeNode root, long l, long r) {
        if (root != null) {
            long left = l;
            long right = r;
            if (root.left != null) {
                if (root.left.val >= root.val || root.left.val <= l) {
                    return false;
                }
                right = root.val;
            }

            if (root.right != null) {
                if (root.right.val <= root.val || root.right.val >= r) {
                    return false;
                }
                left = root.val;
            }

            return DFS(root.left, l, right) && DFS(root.right, left, r);
        } else {
            return true;
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