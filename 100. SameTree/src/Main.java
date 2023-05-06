public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return DFS(p, q);
    }

    private boolean DFS(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val == q.val) {
                return DFS(p.left, q.left) && DFS(p.right, q.right);
            } else {
                return false;
            }
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else {
            return true;
        }
    }

    public class TreeNode {
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