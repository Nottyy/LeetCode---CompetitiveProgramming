import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        if (root == null){
            return result;
        }

        while (q.isEmpty() == false){
            var len = q.size();

            for (int i = 0; i < len; i++){
                var cur = q.poll();

                if (i == len - 1){
                    result.add(cur.val);
                }

                if (cur.left != null){
                    q.add(cur.left);
                }

                if (cur.right != null){
                    q.add(cur.right);
                }
            }
        }

        return result;
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