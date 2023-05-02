import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var node1 = new TreeNode(1);
        var node2 = new TreeNode(2);
        var node3 = new TreeNode(3);
        var node4 = new TreeNode(33);

        node1.right = node2;
        node1.left = node4;
        node2.left = node3;

        var numbers = inorderTraversal(node1);
        List<String> strings = numbers.stream().map(Object::toString).collect(Collectors.toList());

        System.out.println(String.join(" ", strings));


    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        DFS(root, res);

        return res;
    }

    private static void DFS(TreeNode root, List<Integer> res) {
        if (root != null) {
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