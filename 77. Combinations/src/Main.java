import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var s = combine(4, 2);
        for (var p : s) {
            System.out.println(String.join("", p.stream().map(Object::toString).collect(Collectors.toList())));
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        Backtracking(n, k, 1, ds, ans);

        return ans;
    }

    private static void Backtracking(int n, int k, int start,
                                     ArrayList<Integer> ds, List<List<Integer>> ans) {
        if (ds.size() == k) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = start; i <= n; i++) {
            ds.add(i);
            Backtracking(n, k, i + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }
}