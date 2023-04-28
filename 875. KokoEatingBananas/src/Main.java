public class Main {
    public static void main(String[] args) {
        int[] piles = { 30,11,23,4,20};
        System.out.println(minEatingSpeed(piles, 6));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        int max = 0;
        int len = piles.length;

        for (int p: piles){
            sum += p;
            max = Math.max(max, p);
        }

        int left= (int) ((sum + h - 1)/h); // average eating speed
        int num_bites = h/len;
        int right = (max + num_bites - 1)/num_bites; // max eating speed

        while (left <= right) {
            var mid = left + ((right - left) / 2);
            var exceeded = false;
            var count = 0;

            for (int i = 0; i < piles.length; i++) {
                count += mid > piles[i] ? 1 : (piles[i] % mid == 0 ? piles[i] / mid : (piles[i] / mid) + 1);
                if (count > h) {
                    left = mid + 1;
                    exceeded = true;
                    break;
                }
            }

            if (!exceeded){
                right = mid - 1;
            }
        }

        return left;
    }
}