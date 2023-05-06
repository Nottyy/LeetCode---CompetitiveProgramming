public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (val > root.val) {
            if (root.right != null) {
                root.right = insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
            }
        } else {
            if (root.left != null) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
            }
        }

        return root;
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