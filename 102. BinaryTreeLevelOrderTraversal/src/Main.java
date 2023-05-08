import java.util.*;
import java.util.stream.Collectors;

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
        node5.right = node7;
        node7.right = new TreeNode(1111);
        node7.left = new TreeNode(1211);
        var s = levelOrder(node10);


        for (var level: s){
            var p = level.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println(String.join(" ", p));
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (q.isEmpty() == false){
            var len = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < len; i++){
                var cur = q.poll();
                level.add(cur.val);

                if (cur.left != null){
                    q.add(cur.left);
                }

                if (cur.right != null){
                    q.add(cur.right);
                }
            }
            result.add(level);
        }

        return result;
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