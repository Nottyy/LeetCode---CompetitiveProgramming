public class Main {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648, -1));
    }

    // 18 : 3, 6, 12, 24, 48, 96, 192
    public static int divide(int dividend, int divisor) {
        long output = 0;
        long d = Math.abs(Long.valueOf(dividend));
        long dv = Math.abs(Long.valueOf(divisor));

        while (d >= dv) {
            var tmp = dv;
            var mult = 1;

            while (d >= tmp) {
                d -= tmp;
                output += mult;
                mult += mult;
                tmp += tmp;
            }
        }

        if ((dividend < 0 && divisor > 0) || (dividend >= 0 && divisor < 0)) {
            output = output * -1;
        }

        if (output < Integer.MIN_VALUE)
        {
            output = Integer.MIN_VALUE;
        }
        else if (output > Integer.MAX_VALUE){
            output = Integer.MAX_VALUE;
        }

        return (int) output;
    }
}