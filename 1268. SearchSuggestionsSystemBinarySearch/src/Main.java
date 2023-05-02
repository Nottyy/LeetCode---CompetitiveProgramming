import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] prod = {"moubile", "mouse", "moneypot", "monitor", "mousepad"};
        var res = suggestedProducts(prod, "mouse");

        for (var x : res) {
            System.out.println(String.join(" ", x));
        }
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        var n = products.length;
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();

        var prefix = new String();
        for (var c : searchWord.toCharArray()) {
            prefix += c;

            int start = binarySearchPrefix(products, prefix);
            List<String> curRes = new ArrayList<>();

            var len = Math.min(start + 3, n);
            for (int i = start; i < len; i++) {
                if (products[i].startsWith(prefix) == false) {
                    break;
                }

                curRes.add(products[i]);
            }

            res.add(curRes);
        }

        return res;
    }

    private static int binarySearchPrefix(String[] products, String prefix) {
        var l = 0;
        var r = products.length - 1;
        int res = -1;

        while (l <= r) {
            var mid = l + ((r - l) / 2);

            if (products[mid].compareTo(prefix) >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return l;
    }
}