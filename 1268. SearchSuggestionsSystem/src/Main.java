import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        List<String> sorted = Arrays.stream(products).sorted().collect(Collectors.toList());
        ;

        for (int i = 1; i <= searchWord.length(); i++) {
            var ch = searchWord.substring(0, i);

            var p = sorted.stream().filter(x -> x.startsWith(ch)).limit(3).collect(Collectors.toList());
            res.add(p);
        }

        return res;
    }
}