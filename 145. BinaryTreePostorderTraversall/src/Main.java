import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

        var numbers = postorderTraversal(node1);
        List<String> strs = numbers.stream().map(Object::toString).collect(Collectors.toList());

        System.out.println(String.join(" ", strs));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        DFS(root, res);

        return res;
    }

    private static void DFS(TreeNode root, List<Integer> res) {
        if (root != null){
            DFS(root.left, res);
            res.add(root.val);
            DFS(root.right, res);
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