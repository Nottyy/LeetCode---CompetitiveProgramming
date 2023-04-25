import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        var arr = partition("aaba");
        for (var el : arr) {
            System.out.println(String.join(" ", el));
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        DFS(s, result, new LinkedList<>(), 0);
        return result;
    }

    // aabac -> a,a,b,a,c - aa,b,a,c - a,aba,c
    // acba
    private static void DFS(String word, List<List<String>> result,
                            LinkedList<String> curArr, int index) {
        if (index >= word.length()) {
            var res = new ArrayList<>(curArr);
            result.add(res);
            return;
        }

        for (int i = 1; i <= word.length() - index; i++) {
            var curStr = word.substring(index, index + i);

            if (PalindromeCheck(curStr)) {

                curArr.add(curStr);
                DFS(word, result, curArr, index + i);
                curArr.removeLast();
            }
        }
    }

    private static boolean PalindromeCheck(String curStr) {
        if (curStr.length() == 1) {
            return true;
        }

        int start = 0;
        int end = curStr.length() - 1;

        while (start <= end) {
            if (curStr.charAt(start) != curStr.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}