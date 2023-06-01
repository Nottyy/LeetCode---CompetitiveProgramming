import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        var nums = new int[]{4, 5, 8, 2};
        var s = new KthLargest(6, nums);

        var p = s.add(1);
        p = s.add(1);
        p = s.add(1);
        p = s.add(2);
        p = s.add(2);
        System.out.println(p);
    }

    public static class KthLargest {
        private PriorityQueue<Integer> Q;
        private Integer K;

        public PriorityQueue<Integer> getQ() {
            return Q;
        }

        public Integer getK() {
            return K;
        }

        public KthLargest(int k, int[] nums) {
            this.K = k;
            this.Q = new PriorityQueue<>(k);

            for (int i = 0; i < nums.length; i++) {
                this.Q.add(nums[i]);
            }

            while (this.Q.size() > k) {
                this.Q.poll();
            }
        }

        public int add(int val) {
            this.Q.add(val);

            if (this.Q.size() > K) {
                this.Q.poll();
            }

            return this.Q.peek();
        }
    }
}