import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var node10 = new TreeNode(10);
        var node20 = new TreeNode(8);
        var node30 = new TreeNode(30);
        var node5 = new TreeNode(5);
        var node7 = new TreeNode(7);

        node10.left = node5;
        node10.right = node20;
        node20.right = node30;
        node5.right = node7;
        node7.right = new TreeNode(20);
        node7.left = new TreeNode(6);

        recoverTree(node10);
    }

    public static int counter = 0;
    public static void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        DFS(root, list);

        var sorted = list.stream().sorted().collect(Collectors.toList());

        DFSUpdateRoot(root, sorted);
    }

    private static void DFSUpdateRoot(TreeNode root, List<Integer> sorted) {
        if (root != null){
            DFSUpdateRoot(root.left, sorted);
            root.val = sorted.get(counter);
            counter++;
            DFSUpdateRoot(root.right, sorted);
        }
    }

    private static void DFS(TreeNode root, List<Integer> list) {
        if (root != null){
            DFS(root.left, list);
            list.add(root.val);
            DFS(root.right, list);
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