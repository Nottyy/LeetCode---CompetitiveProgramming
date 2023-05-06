public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(10);
        var node2 = new TreeNode(20);
        var node3 = new TreeNode(30);
        var node4 = new TreeNode(40);
        var node5 = new TreeNode(50);
        var node6 = new TreeNode(60);
        var node7 = new TreeNode(70);
        var node25 = new TreeNode(25);
        var node28 = new TreeNode(28);
        var node23 = new TreeNode(23);
        var node27 = new TreeNode(27);


        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;
        node6.right = node7;

        node2.left = node1;
        node2.right = node25;
        node25.right = node28;
        node25.left = node23;
        node28.left = node27;

        var st = deleteNode(node5, 30);
        var s = 4;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null){
            return null;
        }

        if (key > root.val){
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.val){
            root.left = deleteNode(root.left, key);
        }
        else{
            if (root.left == null){
                root = root.right;
            }
            else if (root.right == null){
                root = root.left;
            }
            else{
                TreeNode min = root.left;
                while (min.right != null){
                    min = min.right;
                }


                root.val = min.val;
                root.left = deleteNode(root.left, min.val);

                return root;
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