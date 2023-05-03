import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        var node1 = new TreeNode(4);
        var node2 = new TreeNode(5);
        var node3 = new TreeNode(1);
        var node4 = new TreeNode(10);
        var node5 = new TreeNode(2);
        var node6 = new TreeNode(3);

        node1.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.right = node6;

        var invRoot = invertTree(node1);
        var s = 4;
    }

    public static TreeNode invertTree(TreeNode root) {
        var newRoot = new TreeNode(root.val);
        InvertTree(root, newRoot);

        return newRoot;
    }

    private static void InvertTree(TreeNode root, TreeNode newRoot) {
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> qNew = new LinkedList<>();
        q.add(root);
        qNew.add(newRoot);

        while (q.size() != 0){
            var node = q.remove();
            var nodeNew = qNew.remove();

            if (node.right != null){
                q.add(node.right);
                var r = new TreeNode(node.right.val);
                nodeNew.left = r;
                qNew.add(r);
            }

            if (node.left != null){
                q.add(node.left);
                var l = new TreeNode(node.left.val);
                nodeNew.right = l;
                qNew.add(l);
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